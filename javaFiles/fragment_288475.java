int newWidth = (int) (getResources().getDisplayMetrics().widthPixels * mCurrentPage.getWidth() / 72 * currentZoomLevel / 40);
int newHeight = (int) (getResources().getDisplayMetrics().heightPixels * mCurrentPage.getHeight() / 72 * currentZoomLevel / 64);
Bitmap bitmap = Bitmap.createBitmap(
                newWidth,
                newHeight,
                Bitmap.Config.ARGB_8888);