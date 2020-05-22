if(c.moveToFirst())
    {
           byte[] img=c.getBlob(c.getColumnIndex("Image"));
            if(img!=null)
            {
                Log.e("TAG", " Not null");
            }
            else
            {
                Log.e("TAG", " null");
            }
            ByteArrayInputStream imageStream = new ByteArrayInputStream(img);
            Bitmap theImage= BitmapFactory.decodeStream(imageStream);
            a.setImageBitmap(theImage);

        }
    }