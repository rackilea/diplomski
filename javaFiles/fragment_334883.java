@Override
public void onBackPressed() {
    if(isFullScreen) {
        imaPlayer.getAdPlayer().setFullscreen(false);
        imaPlayer.getContentPlayer().setFullscreen(false);
        // after this calls you will see that your callback method onReturnFromFullscreen() will be called
    }
    else {
        super.onBackPressed();
    }
}