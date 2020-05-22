public void onActivityResult(int requestCode, int resultCode, Intent data){
         // check if the request code is same with which you requested LoginActivity
         if(requestCode == <Request-Code>){
               if(resultCode != Activity.RESULT_OK) {
                   // now finish your activity
                   finish();
               }
         }
    }