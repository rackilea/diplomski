URL url;
    try {
        url = new URL("**cloudfront URL***"+imagePath);
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
            connection.setRequestProperty("charset","UTF-8");
            connection.setRequestProperty("Content-Length",imageByteArray.length+"");
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
            wr.write(imageByteArray);
            wr.flush();
            wr.close();
            connection.disconnect();
            // Check the HTTP response code. To complete the upload and make the object available, 
            // you must interact with the connection object in some way.
            connection.getResponseCode();
            System.out.println("HTTP response code: " + connection.getResponseCode());
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }