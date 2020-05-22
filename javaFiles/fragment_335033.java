MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder();
multipartBodyBuilder.setType(MultipartBody.FORM);
multipartBodyBuilder.addFormDataPart("key", "value");
MediaType mediaType = MediaType.parse("image/png"); // or "image/jpeg" or any mime type you want
multipartBodyBuilder.addFormDataPart(
        "fileKey",
        "fileName",
        RequestBody.create(mediaType, yourFile)
);