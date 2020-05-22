try {
    if(  Uri.parse(paths)!=null   ){  
     Bitmap bitmap = MediaStore.Images.Media.getBitmap(c.getContentResolver() , Uri.parse(paths));
        }
   }
   catch (Exception e) {
            //handle exception
        }