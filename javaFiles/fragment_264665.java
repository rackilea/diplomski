File file_obj = new File(this.file); 
    String authorization = "my authorization string";
    Proxy webproxy = new Proxy(Proxy.Type.HTTP, new 
          InetSocketAddress("proxy", <port>));

    OkHttpClient client = new OkHttpClient.Builder().proxy(webproxy).build();      

    RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", "filename",
        RequestBody.create(MediaType.parse("application/octet-stream"), file_obj)).build();

    Request request = new Request.Builder().header("Authorization", authorization).url(this.url).post(requestBody).build();

    try (Response response = client.newCall(request).execute()){
        if(!response.isSuccessful()) return "NA";
        return (response.body().string());
    }