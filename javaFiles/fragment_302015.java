public static void onActivityResult(int requestCode, int resultCode, Intent data) {

  if(requestCode == 0){
     if(resultCode == RESULT_OK){
        //get the image 
        // process it.

        syso("INSIDE SAMPLE CLASS");
     }

      if(resultCode == RESULT_CANCELED){

      }
   }
}