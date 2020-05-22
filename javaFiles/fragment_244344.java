boolean isRunning = true;


recordingThread = new Thread(new Runnable() {
            public void run() {

                String outputSource = Environment.getExternalStorageDirectory().getAbsolutePath() + folder + "/my.mp3";
                try {
                    fos = new FileOutputStream(outputSource);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int c;
                try {


                    URL url = new URL(mPlayer.getDataSource());
                        inputStream = url.openStream();

                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("GET");
                        con.connect();
                        int status = con.getResponseCode();
                        Log.d(TAG, String.valueOf(status));
                        InputStream is = con.getInputStream();
                        int bytesRead = 0;
                        byte[] buf = new byte[1024];
                        try {
                            while (isRunning && (c = is.read(buf)) != -1) {
                                    Log.d(TAG, " bytesRead=" + bytesRead + " buf: " + Arrays.toString(buf));
                                    try {
                                        fos.write(buf, 0, c);
                                    } catch (IllegalThreadStateException | IOException e) {
                                        e.printStackTrace();
                                    }
                                fos.flush();
                                bytesRead++;
                            }is.close();
                        fos.close();
                    } catch (NullPointerException | SocketException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        recordingThread.start();
    }


  public void stopRecording() {
     isRunning = false;
  }