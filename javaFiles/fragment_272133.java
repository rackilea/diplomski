CancellableCallback callback = new Callback<ImageUpload>() {
            @Override
            public void success(final ImageUpload imageUpload, Response response) {
                mRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        ...
                });
            }

            @Override
            public void failure(RetrofitError error) {

            }
    };

service.upload1(file1, str, stringMap, callback);