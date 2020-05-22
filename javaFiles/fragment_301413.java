String os = System.getProperty("os.name");        
try {
    if(os.indexOf("Windows 7")>=0) {
       Process process = Runtime.getRuntime().exec("ipconfig /all");
       process.waitFor();
       InputStream commandOut= process.getInputStream();
       //Display the output of the ipconfig command
       BufferedReader in = new BufferedReader(new InputStreamReader(commandOut));
       String line;
       while((line = in.readLine()) !=null) 
          System.out.println(line);
    }
}
catch(IOException ioe) {    }
catch(java.lang.InterruptedException utoh) {   }        
}