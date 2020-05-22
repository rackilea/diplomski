ServletOutputStream sos = response.getOutputStream();
   long byteRead = 0;
   try {
       byte[] buf = new byte[8291];
       while (true) {
         int r = is.read(buf);
         if (r == -1)
         break;
         sos.write(buf, 0, r);
         byteRead +=r;
         if(byteRead > 1024*1024){ //flushes after 1mb
           byteRead = 0;
           sos.flush();
         }

      }
    } finally {
    if(sos != null){
      sos.flush();
    }
    try{is.close();}catch(Exception e){}
    try{sos.close();}catch(Exception e){}
 }