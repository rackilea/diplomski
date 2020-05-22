private class LoadImage extends AsyncTask<Integer, Void, Bitmap> {

    private ImageView imv;

    public LoadImage(ImageView imv) {
        this.imv = imv;
    }

    @Override
    protected void onPostExecute(Bitmap result) {

        if (result != null && imv != null) {
            imv.setVisibility(View.VISIBLE);
            imv.setImageBitmap(result);
        } else {
            imv.setVisibility(View.GONE);
        }
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        Bitmap bitmap = null;
        bitmap = BitmapFactory.decodeResource(mContext.getResources(),
                params[0]);
        return bitmap;
    }

}