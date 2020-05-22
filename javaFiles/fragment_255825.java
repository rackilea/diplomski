private void playMusic(String song){
    if(!isPlaying) {
        try {
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mPlayer) {
                    isPlaying = false;
                    mPlayer.reset();
                    songNumber = songNumber + 1;
                    playMusic("/mnt/sdcard/Music/" + fileArray[songNumber]);
                }

            });
            Toast.makeText(getApplicationContext(), song, Toast.LENGTH_SHORT).show();
            mPlayer.setDataSource(song);
            mPlayer.prepare();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception of type : " + e.toString());
            e.printStackTrace();
        }

        mPlayer.start();
        isPlaying = true;
    }else{
        stopMusic();
    }
}