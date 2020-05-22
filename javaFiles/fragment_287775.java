for (Element img : imgs) {

                Element myImage = img;
                String imgSrc = myImage.attr("src");
                InputStream inp = new java.net.URL(imgSrc).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(inp);

               ///HERE YOU SHOULD ADD YOUR BITMAP TO ALL ELEMENTS
               ///eg. allImages.add(bitmap); or whatever.
            }