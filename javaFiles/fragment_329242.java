try {

                mp = new MediaPlayer();

                mp.reset();
                try {
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mp.release();

                    }
                });


                mp.setOnPreparedListener(new OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mpm) {
                        mpm.start();

                        mp.start();


                    }
                });
                mp.prepareAsync();


            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
    });
}

}