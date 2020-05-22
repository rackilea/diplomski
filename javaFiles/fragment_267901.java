String link = "<YOUR_URL>/" + "download.jar"; // jar is binary 
      String            fileName = "download.jar";
      URL               url  = new URL( link );
      HttpURLConnection http = (HttpURLConnection)url.openConnection();
      InputStream  input  = http.getInputStream();
      byte[]       buffer = new byte[2048];
      int          n      = -1;
      OutputStream output = new FileOutputStream( new File( fileName ));
      while ((n = input.read(buffer)) != -1) { //make sure your to check -1 and target buffer to read from
         output.write( buffer, 0, n );
      }
      output.close();