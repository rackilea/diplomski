//All the String parameters
Map<String, RequestBody> map = new HashMap<>();
map.put("methodName", toRequestBody(methodName));
map.put("userid", toRequestBody(userId));
map.put("name", toRequestBody(name));

//To put your image file as well
File file = new File("file_name");
RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
map.put("relative_image\"; filename=\"some_file_name.png\"", fileBody);

// This method  converts String to RequestBody
public static RequestBody toRequestBody (String value) {
    RequestBody body = RequestBody.create(MediaType.parse("text/plain"), value);
    return body ;
}

//To send your request
call = service.postImage(body, params);