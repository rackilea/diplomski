userObject.put(PROFILE_DETAILS_CAMERA_ARRAY_KEY, cameraArray);
userObject.saveInBackground(new SaveCallback() {
           @Override
           public void done(ParseException e) {
                if (e == null) {
                     if (cameraAdapter != null) {
                         cameraAdapter.updatePosition(parseFile.getUrl(), position);
                     }
                } else {
                     Log.e(TAG, "failed " + e.getLocalizedMessage());
                }
           }
});