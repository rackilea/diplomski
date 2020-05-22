if (photos != null) {
    try {
        JSONArray jsonObj = new JSONArray(photos);
        for (int i = 0; i < jsonObj.length(); i++) {

            ...

        JSONObject jsonPhotos = new JSONObject();  // add this line here

        jsonPhotos.put( "imageData", encodedString);
        jsonPhotos.put( "caption", cap);

        claim.accumulate( "photos", jsonPhotos);

    }