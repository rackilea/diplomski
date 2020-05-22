@Override
protected void onDestroy() {
    super.onDestroy();
    try {
        WallpaperManager wpm = WallpaperManager.getInstance(this);
        WallpaperInfo info = wpm.getWallpaperInfo();
        if (info != null && info.getPackageName().equals(this.getPackageName())) {
/*stop music*/
        } else {
            Log.d(TAG, "We're not running");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}