private void nextMedia(){
    MediaPlayer player=playList.get(currentMediaIndex++);
    attachListeners(player);
    if(player!=null){
        player.play();
    } else {
        nextMedia();
    }
}