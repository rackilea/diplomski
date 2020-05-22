@Override
public void onPause() {
super.onPause();
if (Util.SDK_INT <= 23) {
 exoPlayer.release();
}

}

@Override
public void onStop() {
super.onStop();
if (Util.SDK_INT > 23) {
   exoPlayer.release();
 }
}