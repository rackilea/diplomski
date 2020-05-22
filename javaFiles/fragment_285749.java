imageView = (ImageView) findViewById(R.id.image_view);

        new AsyncTask<String, Void, Bitmap>(){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected Bitmap doInBackground(String... url) {
                return downloadFile(url[0]);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                imageView.setImageBitmap(bitmap);
            }
        }.execute(imageHttpAddress);

        private Bitmap downloadFile(String imageHttpAddress) {
            URL imageUrl = null;
            try {
                imageUrl = new URL(imageHttpAddress);
                HttpURLConnection conn =(HttpURLConnection)imageUrl.openConnection(); 
                conn.connect();
                loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
                return loadedImage; 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }