uploadImage(Uri.parse(imageString), prepend, new Callback() {
            @Override
            public void result(Result result) {}

            @Override
            public void uri(Uri downloadUrl) {
                saveObjectInDB(downloadUrl, new Callback() {
                    @Override
                    public void result(Result result) {
                        callback.result(result);
                    }

                    @Override
                    public void url(Uri downloadUrl) { }
                });
            }
        });