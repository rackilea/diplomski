protected Void doInBackground(List<VideoObject>... lists) {
        for(final int i=0; i<toProcess.size(); i++){
            try {
                new Thread(){
                    @Override
                    public void run() {
                        VideoObject item = videoObjectList.get(i);
                        String urldisplay = item.getThumbnailUrl();
                        Bitmap mIcon11 = null;
                        try {
                            InputStream in = new java.net.URL(urldisplay).openStream();
                            mIcon11 = BitmapFactory.decodeStream(in);
                        } catch (Exception e) {
                            Log.e("Error", e.getMessage());
                            e.printStackTrace();
                        }
                        item.setThumbnail(mIcon11);
                        publishProgress(item);
                    }
                }.start();
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(VideoObject... values) {
        adapter.notifyDataSetChanged();
    }