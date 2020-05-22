String url = "http://www.myurl.com/data.php";

BufferedReader inStream = null; 
HttpClient httpClient = new DefaultHttpClient();
HttpGet httpRequest = new HttpGet(url);

try {

       HttpResponse response = httpClient.execute(httpRequest);
       inStream = new BufferedReader(
       new InputStreamReader(
       response.getEntity().getContent()));

       StringBuffer buffer = new StringBuffer("");
       String line = "";

       while ((line = inStream.readLine()) != null) {
                buffer.append(line);
            }
            inStream.close();

            reply = buffer.toString();  
        } catch (Exception e) {
                //Handle Exception
        }