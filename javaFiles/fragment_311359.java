public void post() throws Exception{
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://www.baidu.com");
        String xml = "<xml>xxxx</xml>";
        HttpEntity entity = new ByteArrayEntity(xml.getBytes("UTF-8"));
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());
    }