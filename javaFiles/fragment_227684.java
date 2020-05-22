public static void SaveWorkFlow() throws IOException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(myURLgoesHERE);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("task", "savemodel"));
        params.add(new BasicNameValuePair("code", generatedJSONString));
        CloseableHttpResponse response = null;
        Scanner in = null;
        try
        {
            post.setEntity(new UrlEncodedFormEntity(params));
            response = httpClient.execute(post);
            // System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            in = new Scanner(entity.getContent());
            while (in.hasNext())
            {
                System.out.println(in.next());

            }
            EntityUtils.consume(entity);
        } finally
        {
            in.close();
            response.close();
        }
    }