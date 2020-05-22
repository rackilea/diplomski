private MediaPlayer createPlayer(String filePath) {
    try{
        Media media = new Media(new File(dir+"/"+filePath).toURI().toString());
        MediaPlayer player=new MediaPlayer(media);
        return player;
    } catch(MediaException me){
        System.out.println("MediaException "+me);
    }
    return null;
}