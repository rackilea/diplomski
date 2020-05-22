protected void onPostExecute(JSONObject product) {
    if (product != null) {
        // product with this pid found
        // Edit Text
        txtMessage = (EditText) findViewById(R.id.txtMessage);

        StringBuilder jsonStringBuilder = new StringBuilder(); //Create StringBuilder for concatenation of JSON results

        // display profile data in EditText
        try {
            //txtMessage.setText(product.getString(TAG_FIRSTNAME));  //Don't set the text here
            jsonStringBuilder.append(product.getString(TAG_FIRSTNAME)); //Concatenate each separate item
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //txtMessage.setText(product.getString(TAG_LASTNAME));
            jsonStringBuilder.append(product.getString(TAG_LASTNAME));
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //txtMessage.setText(product.getString(TAG_ADDRESS));
            jsonStringBuilder.append(product.getString(TAG_ADDRESS));
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //txtMessage.setText(product.getString(TAG_COMMENTS));
            jsonStringBuilder.append(product.getString(TAG_COMMENTS));
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //txtMessage.setText(product.getString(TAG_AGE));
            jsonStringBuilder.append(product.getString(TAG_AGE));
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //txtMessage.setText(product.getString(TAG_GENDER));
            jsonStringBuilder.append(product.getString(TAG_GENDER));
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //txtMessage.setText(product.getString(TAG_HEIGHT));
            jsonStringBuilder.append(product.getString(TAG_HEIGHT));
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //txtMessage.setText(product.getString(TAG_WEIGHT));
            jsonStringBuilder.append(product.getString(TAG_WEIGHT));
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //txtMessage.setText(product.getString(TAG_INFORMATION));
            jsonStringBuilder.append(product.getString(TAG_INFORMATION));
            jsonStringBuilder.append(System.getProperty("line.separator"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        txtMessage.setText(jsonStringBuilder.toString());
    }

}