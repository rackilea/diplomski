InputStream in = null;
OutputStream out = null;

if (target != null) {
  while(n<3){
    try {       
        if (!target.exists()) {
            target.createNewFile();
            log.debug("target file created for " + target);
            log.debug("downloading source .... " + source);

            if (source == null) {                   
                log.debug("Null source .... " + ScormFileWriter.class.getName());
                return;         
            } else {    
                in = source.openStream();   
            }   
            out = new FileOutputStream(target);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            log.debug("The contents from the URL: " + source + " are successfully written to the file " + target);

        } else {
            log.debug("skipping creation of asset");
        }
        n=4; or break;
    } catch (Exception e) {


            log.debug("trouble with " + target);
            if (in != null) {       
                in.close(); 
            }
            if (out != null) {  
                 out.close();   
            }

            // Attempt to delete it
            boolean success = target.delete();

            if (!success) { 
                log.debug("Unable to delete " + target);

            } else {
               // copyFileFromUrl(source, target, ++count);
            }               

           n++;
         if(n == 2){
            log.debug("trouble in downloading source after trying " + count +  " times: " +           source);
            e.printStackTrace();        
        }
    } finally {         
        if (in != null) {               
            in.close();             
        }           
        if (out != null) {              
             out.close();               
        }             
    }       
  }