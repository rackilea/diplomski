Bitmap bmp = BitmapFactory.decodeFile(imgArray.get(i));
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);


            Image image = Image.getInstance(stream.toByteArray());
            doc.add(image);


        }