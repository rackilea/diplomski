FTPClient ftp = new FTPClient();


    ftp.connect(InetAddress.getLocalHost(), 2221);// or "localhost" in your case
      String loging_success = ftp.login("myNewUser", "secret") == true ? "success" : "failed"; 
      System.out.println("login: "+ loging_success);


      FTPFile[] files = ftp.listFiles();  
      System.out.println("Listed "+files.length+" files.");
      for(FTPFile file : files) {
       System.out.println(file.getName());
      }