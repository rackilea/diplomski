class VideoRatedEvent {
    /** The video that was rated */
    public Video video;
    /** The user that triggered this event */
    public User user;
    /** True if the user liked the video, false if the user disliked the video */
    public boolean liked;
}