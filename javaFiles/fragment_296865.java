public void showViewOfReceiptInLayout(Bitmap imageBitmap)
         {
             byte[] imageData = null;
                 imageBitmap = Bitmap.createScaledBitmap(imageBitmap, yourWidth, yourHeight, false);
                 ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                 imageData = baos.toByteArray();
                 ImageView image = new ImageView(this); 
                 image.setImageBitmap(imageBitmap);
                 layout.addView(image);

         }