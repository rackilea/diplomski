String col = "author";
    String table = "books";    
    String condition = "1";

    try{
            List<NameValuePair> params = new ArrayList<NameValuePair>(); 
            params.add(new BasicNameValuePair("col", col));
            params.add(new BasicNameValuePair("table", table));
            params.add(new BasicNameValuePair("condition", condition)); 

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://www2.XXXX./XXXX/X.php");
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        }catch(Exception e){
            e.printStackTrace(); 
            System.out.println("Exception 1 caught");
        }