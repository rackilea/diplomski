byte[] byteArray = ...
    TypedInput typedBytes = new TypedByteArray("application/octet-stream",  byteArray);
    remoteService.upload(typedBytes, new Callback<String>() {
        @Override
        public void success(String s, Response response) {
            //Success Handling
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            //Error Handling
        }
    });