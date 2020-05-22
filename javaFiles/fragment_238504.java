if(httpConnection.getResponseCode() !=200){
        String error_resp;
        InputStream in = httpConnection.getErrorStream();
        if (in == null) return; // check if the error stream is null
       BufferedReader error_responseBuffer = new BufferedReader(new InputStreamReader(
            (httpConnection.getErrorStream()))); 
       while((error_resp = error_responseBuffer.readLine()) != null){
           System.out.println("Error responsecode => "+httpConnection.getResponseCode()+"error => "+error_resp);
           output = new JSONObject(error_resp);
       }
    }else {
        InputStream in = httpConnection.getInputStream();
        if (in == null) return; // check inputstream
        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                (in)));
        String httpresponse;
        StringBuilder content = new StringBuilder();
        while((httpresponse = responseBuffer.readLine()) != null){
            content.append(httpresponse);
        }
         output = new JSONObject(content.toString());
    }
    httpConnection.disconnect();