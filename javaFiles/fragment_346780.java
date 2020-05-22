for (int n = message.length; i < n; i++)
            {   
                Log25.write("IMAPaccess", "getMessages", "start convert");
                MimeMessage msg = (MimeMessage)message[i];

                ByteArrayOutputStream bos = new ByteArrayOutputStream();


                // MJN1 has some SPAM email cannot be converted, so use thread to do the conversion 
                final Runnable stuffToDo = new Thread() {
                      @Override 
                      public void run() { 
                          try {
                            Log25.write("IMAPaccess", "run", "write to MimeMessage");
                            msg.writeTo(bos);
                            Log25.write("IMAPaccess", "run", "wrote to MimeMessage");
                        } catch (IOException | MessagingException e) {
                            Log25.write("IMAPaccess", "run", (new StringBuilder()).append("error = ").append(e.getMessage()).toString());

                        }
                      }
                    };

                final ExecutorService executor = Executors.newSingleThreadExecutor();
                final Future future = executor.submit(stuffToDo);
                executor.shutdown(); // This does not cancel the already-scheduled task.

                // start the conversion and if the process hangs, the loop should skip and continue
                try { 
                  future.get(1, TimeUnit.SECONDS); 
                }
                catch (InterruptedException ie) { 
                    Log25.write("IMAPaccess", "getMessages", (new StringBuilder()).append("error = ").append(ie.getMessage()).toString());
                    continue;
                }
                catch (ExecutionException ee) { 
                    Log25.write("IMAPaccess", "getMessages", (new StringBuilder()).append("error = ").append(ee.getMessage()).toString());
                    continue;
                }
                catch (TimeoutException te) { 
                    Log25.write("IMAPaccess", "getMessages", (new StringBuilder()).append("error = ").append(te.getMessage()).toString());
                    continue;
                }
                catch(Exception e) {
                    Log25.write("IMAPaccess", "getMessages", (new StringBuilder()).append("error = ").append(e.getMessage()).toString());
                    continue;
                }
                if (!executor.isTerminated())
                    executor.shutdownNow();

                bos.close();