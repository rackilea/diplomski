private void CopyReadVdo(int vdoname) {
    setContentView(R.layout.video_player);

    VideoView view = (VideoView) findViewById(R.id.videoview);
    String path = "android.resource://" + getPackageName() + "/" + vdoname;
    Uri uri = Uri.parse(path);
    view.setVideoURI(uri);
    MediaController mediaController = new MediaController(this);
    mediaController.setAnchorView(view);
    view.setMediaController(mediaController);
    view.start();
}