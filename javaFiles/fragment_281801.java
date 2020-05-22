HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://directclientvendors.com/news24/api/get.php?type=news");
        HttpResponse response = client.execute(request);
        InputStream content = response.getEntity().getContent();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(content, "UTF-8"));
        jsonReader.beginObject();
        if(jsonReader.hasNext())
        {
            System.out.println(jsonReader.nextName()); // prints 'news'
            // BEGIN_ARRAY etc to parse the rest
        }
        // END_OBJECT and cleanup