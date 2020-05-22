YouTubePlayerView youtubePlayerView = findViewById(R.id.youtube_player_view);
getLifecycle().addObserver(youtubePlayerView);

youtubePlayerView.initialize(new YouTubePlayerInitListener() {
    @Override
    public void onInitSuccess(@NonNull final YouTubePlayer initializedYouTubePlayer) {
        initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady() {
                String videoId = "6JYIGclVQdw";
                initializedYouTubePlayer.loadVideo(videoId, 0);
            }
        });
    }
}, true);