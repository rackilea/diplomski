private void trySave(Whatever image. String file) {
   try {
       saveToInternalStorage(image.getDrawable().getBitmap(), file);
   } 
   catch (Exception exc) {
        exc.printStackTrace();
   }
}