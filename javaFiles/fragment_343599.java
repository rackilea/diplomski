Request photoRequest = Request.newUploadStagingResourceWithImageRequest(session, bitmap, new Request.Callback() {
        @Override
        public void onCompleted(Response response) {
            if (mProgress != null && mProgress.isShowing())
                mProgress.dismiss();

            if (response.getError() == null) {
                Toast.makeText(NewPostActivity.this, "Successfully shared on the group", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(NewPostActivity.this, "Facebook sharing error: " + response.getError().getErrorMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    });

    Bundle params = photoRequest.getParameters();
    if(message != null) {
        params.putString("message", message);
        photoRequest.setGraphPath(Constants.URL_FEEDS);
    }
    if(imageBytes != null) {
        params.putByteArray("picture", imageBytes);
        photoRequest.setGraphPath(Constants.URL_PHOTOS);
    }
    photoRequest.setParameters(params);
    photoRequest.setHttpMethod(HttpMethod.POST);
    photoRequest.executeAsync();