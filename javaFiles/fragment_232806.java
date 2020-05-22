HttpClient client = HttpClientBuilder.create().build();
      HttpResponse response = null;
      try {    

            String url = ResourceBundle.getBundle("resourses").getString("url");

            HttpPost post = new HttpPost(url);
            // add header
            post.setHeader("User-Agent", "Mozilla/5.0");

            StringEntity entity = new StringEntity(StringXMLDATA, HTTP.UTF_8);

            entity.setContentType("application/x-www-form-urlencoded");
            entity.setChunked(true);
            post.setEntity(entity);

            response = client.execute(post);
            System.out.println("Response Code : "     + response.getStatusLine().getStatusCode()+"    Response StatusLine : "     + response.getStatusLine());

            InputStreamReader isp = new InputStreamReader(response.getEntity().getContent());
            BufferedReader rd = new BufferedReader(isp);

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println("line : "+line);
                result.append(line);
            }
            System.out.println("Result :   " + result);
    }catch (Exception cpe) {
        System.out.println(cpe);
    }finally { 
        client.getConnectionManager().shutdown(); 
    }