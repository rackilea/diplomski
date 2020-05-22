HttpGet get = new HttpGet("http://stackoverflow.com");
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);       

        long endTime = System.currentTimeMillis();
        long duration = (endTime-startTime);
        totalTimeMS +=duration;
        System.out.println(convertStreamToString(response.getEntity().getContent()));
        System.out.format("Duration %d ms\n", duration);