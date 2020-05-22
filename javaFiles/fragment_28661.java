@Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap != null) {
                Bitmap bmp = bitmapReference.get();
                if(bmp != null) {
                    bmp = bitmap;
                }
            }
        }