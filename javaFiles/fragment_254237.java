ArrayList<String> mStrings=new ArrayList<String>(;
        for (int i = 0; i < productObj.length(); i++) {
            JSONObject image = productObj.getJSONObject(i);

            mStrings.add(image.getString(TAG_PATH));
         }