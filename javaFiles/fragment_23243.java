String executePost(String targetURL, String urlParameters){

    URL url;
    HttpURLConnection connection = null;        
    try{
        //Create connection

        url = new URL(targetURL);
        connection = (HttpURLConnection)url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", 
                   "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Language", "en-US"); 
        connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //send Request 
        DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
        dataout.writeBytes(urlParameters);
        dataout.flush();
        dataout.close();

        //get response
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();

        while((line = br.readLine()) != null){
            response.append(line);
            response.append('\n');

        }
        System.out.println(response.toString());
        br.close();
        return response.toString();
    }catch(Exception e){
        System.out.println("Unable to full create connection");
        e.printStackTrace();
        return null;
    }finally {

          if(connection != null) {
            connection.disconnect(); 
          }
    }


}