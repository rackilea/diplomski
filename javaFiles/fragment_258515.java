//This method receives 2 parameters and return string - just example...
//I'm using HttpGet but there are also HttpPost objects
    public int getResults(String yourParameter1,String yourParameter2)


 {
        int results=0;
        Log.d("Webservice call:","Started");
        //Creating the get URL

        String url= "http://my.webservice.url/targetfile.aspx?parameter1="+yourParameter1+"&parameter2'"+yourParameter2;

        Log.d("URL:",url);
        HttpClient hc = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        String tempresult="";
        Log.d("hc",hc.toString());
        Log.d("post",get.getURI().toString());
         try {
             HttpResponse rp = hc.execute(get);
             Log.d("rp",rp.getEntity().toString());
             Log.d("rp2",rp.getStatusLine().toString());
             // Get hold of the response entity
                HttpEntity entity = rp.getEntity();
                // If the response does not enclose an entity, there is no need
                // to worry about connection release
                tempresult=rp.toString();
                Log.d("tempresult",tempresult);
               if (entity != null) {

                    // A Simple JSON Response Read
                    InputStream instream = entity.getContent();
                    tempresult= convertStreamToString(instream);
                    // now you have the string representation of the HTML request
                    instream.close();
                    Log.d("result",tempresult.toString());
                }
                //tempresults holding the JSON 
             JSONObject json = new JSONObject(tempresult);
             //getting the "results" value 
             results=Integer.parseInt(json.getString("result"));

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("error parsing JSON",e.toString());
                        }

         return results;
    }


//This method is to handle response
    private static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}