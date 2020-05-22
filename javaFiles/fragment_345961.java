URL url = null;
                        try {
                            url = new URL("image url" + object.getString("image"));
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }
                        Bitmap bmp = null;
                        try {
                            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        txtv2.setImageBitmap(bmp);

                        // something went wrong