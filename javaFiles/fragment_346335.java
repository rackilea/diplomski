private void getPlaylist(){

  FindPreviousPlaylistTask previousPlaylistTask=new 
    FindPreviousPlaylistTask( new AsyncResponse(){
    @Override
    void processFinish(PlaylistListResponse output){
        //here your AsyncTask response will be available in output valiable
        //you can do whatever you want here
     }

  }).execute();

}