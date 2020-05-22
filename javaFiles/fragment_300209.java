File file = new File(filePath);

RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
MultipartBody.Part body = MultipartBody.Part.createFormData("upload", file.getName(), reqFile);
RequestBody name = RequestBody.create(MediaType.parse("text/plain"), "upload_test");

retrofit2.Call<okhttp3.ResponseBody> req = service.postImage(body, name);
req.enqueue(new Callback<ResponseBody>() {
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) { 
        // Do Something
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        t.printStackTrace();
    }
});