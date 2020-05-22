File sourceFile = new File("/Users/secret/Desktop/temp/16-27513/Digital Storefront Receipt.png");

final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

RequestBody body = new MultipartBody.Builder()
                   .setType(MultipartBody.FORM)                                     
                   .addFormDataPart("uploadedFile", "Digital Storefront Receipt.png", RequestBody.create(MEDIA_TYPE_PNG ,sourceFile))
                   .build();

Request request = new Request.Builder()
  .url("https://secret.attask-ondemand.com/attask/api-internal/upload/?apiKey=secret")
  .post(body)
  .addHeader("content-type", "multipart/form-data; boundary=---011000010111000001101001")
  .addHeader("cache-control", "no-cache")
  .build();

OkHttpClient client = new OkHttpClient();

Response response = client.newCall(request).execute();
String json = response.body().string();
System.out.println(json.toString());