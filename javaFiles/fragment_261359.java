String f = getAppHomePath() + "videoName.mp4";
if(Util.downloadUrlToFile(url, f, true)) {
    video = MediaManager.createMedia(f, () -> {
          videoIsPlaying = false;
          videoCounter++;
      });

}