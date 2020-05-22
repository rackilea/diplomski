String ddname = ZFile.allocDummyDDName();
 String cmd = "alloc fi("+ddname+") da(HLQ.MYDATA) reuse shr msg(2)";
 ZFile.bpxwdyn(cmd);
 RecordReader reader = null;
 try {
   reader = RecordReader.newReaderForDD(ddname);
   byte[] recordBuf = new byte[reader.getLrecl()];
   while ((bytesRead = reader.read(recordBuf)) >= 0) {
     ...
   }
 } finally {
   if (reader != null) {
     try {
       reader.close(); 
     } catch (ZFileException zfe) {
       zfe.printStackTrace();  // but continue
     } 
   }
   try {
     ZFile.bpxwdyn("free fi(" + ddname + ") msg(2)");
   } catch (RcException rce) {
     rce.printStackTrace();  // but continue
   }
 }