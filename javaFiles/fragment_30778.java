HttpClient client = new HttpClient();
    String url = "https://accounts.google.com/o/oauth2/token";
    PostMethod post = new PostMethod(url);
    post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    try {
        post.setRequestEntity(new StringRequestEntity(foros, null, null));
    } catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e);
    }
    String accessToken = null;
    try {
        client.executeMethod(post);
        String resp = post.getResponseBodyAsString();
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(resp);
        JSONObject parsed = (JSONObject)obj;            
        accessToken = (String) parsed.get("access_token");
    } catch (HttpException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }