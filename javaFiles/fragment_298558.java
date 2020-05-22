public void onClick(View v) {

            if(mp.isPlaying())
            {
                mp.stop();
            } else{

            try {
                mp = MediaPlayer.create(this, R.raw.hello);
                mp.prepare();
                mp.start();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }