String[] mStrings;  //<< Declare array as
        mStrings = new String[productObj.length()];  //<<initialize here

        for (int i = 0; i < productObj.length(); i++) {
            JSONObject image = productObj.getJSONObject(i);
            mStrings[i] = image.getString(TAG_PATH);
         }