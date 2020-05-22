try{
        ChainedBlobstoreInputStream inputStream = new ChainedBlobstoreInputStream(this.getHtmlBlobKey());
        //StringWriter writer = new StringWriter();
         byte[] data = IOUtils.toByteArray(inputStream);
         return new String(Functions.decompress(Encrypt.AESDecrypt(data)));
         //return new String(data);
    } 
    catch(Exception e){
            return "No HTML Version";
        }