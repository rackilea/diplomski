public static Boolean excutePost(String targetURL, JSONObject jsonParam)
    {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST"); // hear you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
            connection.connect();

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream ());
            wr.writeBytes(jsonParam.toString());
            wr.flush();
            wr.close ();

            InputStream is;
            int response = connection.getResponseCode();
            if (response >= 200 && response <=399){
                //return is = connection.getInputStream();
                return true;
            } else {
                //return is = connection.getErrorStream();
               return false;
            }


        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }