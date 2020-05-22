if (response.isSuccessful()) {
   try { 
       final byte[] input = response.body().bytes();
       final int len = (int) response.body().contentLength();
   } catch (IOException e) {
       // Signal to the user failure here, re-throw the exception, or 
       // whatever else you want to do on failure
   }
   ...