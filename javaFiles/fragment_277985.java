videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
     @Override
     public void onCompletion(MediaPlayer mediaPlayer) {
           startActivity(new Intent(splash_screen.this, Menu.class));
           finish();//close activity
     }
});