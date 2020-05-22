Thread t1 = new Thread(new Runnable() {
                public void run()
                {
                    try{
                        Decoder decoder = new Decoder();
                            File file = new File("C:" + File.separator + "as.mp3");
                            FileInputStream in = new FileInputStream(file);
                            BufferedInputStream bin = new BufferedInputStream(in, 128 * 1024);
                            decoder.play(file.getName(), bin);
                            in.close();

                        decoder.stop();
                    }
                    catch(Exception exc){
                        exc.printStackTrace();
                        System.out.println("Failed to play the file.");
                    }
                }});  
                t1.start();