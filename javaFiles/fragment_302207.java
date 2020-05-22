HttpClient client = new DefaultHttpClient();
 HttpPost post = new HttpPost(urlAsString);

 HttpResponse rsp = null;

    try {
        rsp = client.execute(post);
    } catch (IOException e) {
        //ha ha
    } finally {
        //close stuff
    }