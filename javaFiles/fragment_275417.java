if (e.getSource() == btnPlay) {
     if(thread2Status) {
          mp3_player.play();
          lblPlaying.setText("Enjoy the music!");
     }
     else {
          stop();
    }
    thread2Status = !thread2Status;  // this line switches boolean
}