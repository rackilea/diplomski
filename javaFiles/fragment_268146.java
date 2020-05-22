for(int i=0; i<video.getTracks().size();i++){
    Track videoTrack = video.getTracks().get(i);
    if(videoTrack.getHandler().equals("vide)){
        TrackMetaData metaData = videoTrack.getTrackMetaData();
        //Get timescale
        long timeScale = metaData.getTimescale();
        //Get video duration in Us
        long durationUs = videoTrack.getDuration() * 1000 *1000 / timeScale;
        //Get total frames
        long totalFrames = videoTrack.getSamples().size();
        //Calculate the frame duration
        long perFrameDurationUs =  durationUs /  totalFrames;
        //FPS
        long fps = 1000 * 1000 / perFrameDurationUs;
    }
}