public void setWall(View v) {
    WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
    try {
        // below line of code will set your current visible pager item to wallpaper
        // first we have to fetch bitmap from visible view and then we can pass it to wallpaper
        myWallpaperManager.setBitmap(getBitmapFromView(v));

    } catch (IOException e) {
        e.printStackTrace();
    }
}