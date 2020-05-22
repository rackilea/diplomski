if (reqCode == RESULT_CODE_COMPRESS_VIDEO) {
                   if(resCode == RESULT_OK) {
                   if (uri != null) {
                       compress();
                   }
                   }
                   else if(resCode == RESULT_CANCELED && data!=null){
                       Toast.makeText(MainActivity.this,"No Video Recorded",Toast.LENGTH_SHORT).show();
                   }

               }