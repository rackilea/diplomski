AssetManager manager = getAssets();

                // read a Bitmap from Assets
                InputStream open = null;
                try {
                        open = manager.open("logo.png");
                        Bitmap bitmap = BitmapFactory.decodeStream(open);
                        // Assign the bitmap to an ImageView in this layout
                        ImageView view = (ImageView) findViewById(R.id.imageView1);
                        view.setImageBitmap(bitmap);
                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        if (open != null) {
                                try {
                                        open.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                }