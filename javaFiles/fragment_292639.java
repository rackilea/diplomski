private void stopRecording() {
      try{
       if(mRecorder!=null && isRecording){
         mRecorder.stop();
         mRecorder.release();
         mRecorder = null;
       }
     }catch (Exception e){//handle this exception} 
    }