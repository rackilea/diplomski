while(in == null){
       //wait for a second before checking the in stream again
       try {
            sout("inputstream is null! Waiting for a second to test again");
            Thread.sleep(1000);
       } catch (InterruptedException ex) {
          Logger.getLogger(WebManager.class.getName()).log(Level.SEVERE, null, ex);
       }    
    }

     //now your in is available. Read the data and proceed
     String line = null;
     while ((line = in.readLine()) != null) {
          sout(line);
     }