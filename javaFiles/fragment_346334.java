public class FindPreviousPlaylistTask extends AsyncTask<Void, Void, 
  PlaylistListResponse> {

   public interface AsyncResponse {
         void processFinish(PlaylistListResponse output);
      }
  public AsyncResponse delegate = null;

   public FindPreviousPlaylistTask (AsyncResponse delegate){
    this.delegate = delegate;
    }

    @Override
    protected PlaylistListResponse  doInBackground(Void... params) {

        YouTube.Playlists.List playlistsListMineRequest = 
     getYoutube().playlists()
                .list("snippet,contentDetails")
                .setMine(true)
                .setMaxResults(50L);

        ArrayList<Playlist> foundPlaylists = new ArrayList<Playlist>();

        PlaylistListResponse response = playlistsListMineRequest.execute(); 
     //Async call

        return response;

     return null;
 }

 @Override
 protected void onPostExecute(PlaylistListResponse result) {
    delegate.processFinish(result);
  }

}