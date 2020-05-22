DownloadContent.run("fost19", "12345", new DownloadContent.Callback() {
        @Override
        public void onLoaded(String content) {
            Log.d("DownloadContent", content);
            //TODO display content in user interface
        }

        @Override
        public void onNotLoaded() {
            Log.d("DownloadContent", "could not fetch content from website");
            // TODO show error message
        }
    });