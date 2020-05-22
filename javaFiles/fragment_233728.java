org.apache.http.HttpResponse my_response = client.execute(post);
...
System.out.println("Response Code : " +
                my_response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(my_response.getEntity().getContent()));