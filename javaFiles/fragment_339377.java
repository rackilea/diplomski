String[] listOfFiles = new String[0];
                    try {
                        listOfFiles = getAssets().list("");
                        //  int itemIndex = (int) (Math.random() * listOfFiles.length);
                        int itemIndex = 1;
                        String file = listOfFiles[itemIndex];
                        AssetFileDescriptor afd = null;
                        afd = getAssets().openFd(file);

                        MediaPlayer mediaPlayer = new MediaPlayer();
                        mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());

                        mediaPlayer.prepare();
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                mediaPlayer.start();
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }