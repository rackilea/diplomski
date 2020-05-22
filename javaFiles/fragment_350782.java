MediaPlayer mp1=MediaPlayer.create(getBaseContext(), R.raw.sound1);  
MediaPlayer mp2=MediaPlayer.create(getBaseContext(), R.raw.sound2);         

mp1.prepare();
mp2.prepare();   
mp1.start();
mp1.setNextMediaPlayer(mp2);