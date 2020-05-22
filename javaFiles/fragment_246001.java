HttpResponse response = client.execute(post);
    System.out.println("Response Code : " 
                + response.getStatusLine().getStatusCode());

    BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));

    StringBuffer result = new StringBuffer();
    String line = "";