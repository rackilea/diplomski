private void loadTopico() {
        YouTubePlayerFragment mainVideo = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.main_video);

        mainVideo.initialize(Config.YOUTUBE_API, new YouTubePlayer.OnInitializedListener() {

             @Override
             public abstract void onInitializationSuccess (YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored){
                  player.cueVideo(getResources().getString(R.string.principal_funcoes));
             }                                     

             @Override
             public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

             }
       });
}