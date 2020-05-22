class YouTubeVideoInfo {
                private String channel;
                private String url;
                private long views;
                private int comments;
                private int ratings;
                private int likes;
                private int dislikes;
                private String thumbnail;
                private String title;
                .....
        }

        public static final String YOUTUBE_GDATA_SERVER = "http://gdata.youtube.com";
        public static final String USER_FEED_PREFIX = YOUTUBE_GDATA_SERVER + "/feeds/api/users/";
        public static final String UPLOADS_FEED_SUFFIX = "/uploads";
    ...............
        public YouTubeVideoInfo getVideoInfo(YouTubeService service, String channel, String url) {
VideoFeed videoFeed = service.getFeed(
        new URL(USER_FEED_PREFIX + channel + UPLOADS_FEED_SUFFIX), VideoFeed.class);
List<VideoEntry> videoEntries = videoFeed.getEntries();
for (VideoEntry videoEntry : videoEntries) {

    YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();
    if (mediaGroup != null && mediaGroup.getPlayer() != null && videoEntry.getTitle() != null) {

        if (url.equals(mediaGroup.getPlayer().getUrl())) {
            String title = videoEntry.getTitle().getPlainText();

            MediaKeywords keywords = mediaGroup.getKeywords();

            MediaPlayer mediaPlayer = mediaGroup.getPlayer();


            final YtStatistics statistics = videoEntry.getStatistics();

            final YouTubeVideoInfo videoInfo = new YouTubeVideoInfo(channel,
                    mediaPlayer.getUrl(), statistics != null
                    ? statistics.getViewCount() : 0);

            if (videoEntry.getComments() != null
                    && videoEntry.getComments().getFeedLink() != null)
                videoInfo.comments =
                        videoEntry.getComments().getFeedLink().getCountHint();

            final Rating rating = videoEntry.getRating();
            if (rating != null)
                videoInfo.ratings = rating.getNumRaters();

            final YtRating ytRating = videoEntry.getYtRating();

            if (ytRating != null) {
                videoInfo.likes = ytRating.getNumLikes();
                videoInfo.dislikes = ytRating.getNumDislikes();
            }


            final List<MediaThumbnail> thumbnails = mediaGroup.getThumbnails();
            if (!thumbnails.isEmpty())
                videoInfo.thumbnail = thumbnails.get(thumbnails.size() / 2).getUrl();

            if (videoEntry.getTitle() != null)
                videoInfo.title = videoEntry.getTitle().getPlainText();

            return videoInfo;
        }
    }
    .... // exception handling