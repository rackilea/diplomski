UploadPhotoRetroService service = ServiceGenerator.createService(MyActivity.class, "base-url");
TypedFile typedFile = new TypedFile("image/jpeg", new File(imagePath));
service.upload(typedFile, new Callback<String>() {
    @Override
    public void success(String result, Response response) {
        // success call back    
    }
    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
});