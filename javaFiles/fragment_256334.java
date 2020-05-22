if(fileUri1 != null) {
                bitmap1 = BitmapFactory.decodeFile(fileUri1.getPath(),
                        options);
                ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                if(bitmap1 != null) {
                    bitmap1.compress(Bitmap.CompressFormat.PNG, 50, baos1);
                    byte[] b1 = baos1.toByteArray();
                    bitmapstring1 = Base64.encodeToString(b1, 

                    Base64.DEFAULT);
                }
            }