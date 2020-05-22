finally {
  try {
   if (null != fileIn) {
    fileIn.close();
   }
   if (null != buffIn) {
    buffIn.close();
   }
   if (null != inData) {
    inData.close();
   }
  } catch (Exception exFinally) {
   // some stuff
   someArray= null;
  }
 }