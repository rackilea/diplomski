private void savePicturePermitted(){

   // the actual code
   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
   if(intent.resolveActivity(getPackageManager()) != null){

       File photo = null;
       try{

           String time = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
           String name = "GUYZ_" + time;

           File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
           photo = File.createTempFile(name, ".jpg", directory);

           // keep track of the URI
           lastURI = photo.getAbsolutePath();
       }catch(IOException ioe){
           ioe.printStackTrace();
       }

       if(photo != null){
           //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
           intent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", photo));
           startActivityForResult(intent, SAVE_PICTURE);
       }
   }