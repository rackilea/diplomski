public static void main(String[] args){
   private void addSongfromAlbum(){
       System.out.println("Please select a Song to add to the Playlist\n");
       String name = scanner.nextLine();
       playlist.addSongToPlaylist(name);
   }
}