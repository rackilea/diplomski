String targetURL="http://localhost:7001/smartquote_nodocuments/session";
 String urlParameters="timezoneOffset=-330&daylightSaving=false";
    try {

    URL url = new URL(targetURL);

      connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type",
           "application/x-www-form-urlencoded");

    connection.setRequestProperty("Content-Length", "" +
               Integer.toString(urlParameters.getBytes().length));
      connection.setRequestProperty("Content-Language", "en-US");
      connection.setUseCaches (false);
      connection.setDoInput(true);
      connection.setDoOutput(true);

      // Send request
      DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
      wr.writeBytes (urlParameters);
      wr.flush();
      wr.close();

      // Get Response
      InputStream is = connection.getInputStream();
      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
      String line;
      StringBuffer response = new StringBuffer();
      while((line = rd.readLine()) != null) {
        response.append(line);
        response.append('\r');
      }
      rd.close();
      System.out.println("Http request response '{}': "+response.toString());
    }catch(Exception e){
        e.printStackTrace();
    }}}