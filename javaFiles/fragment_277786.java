@Override
    public void onResponse(JSONObject response) {
        myParsedArray = parseResponse(response);
        updateViews(myParsedResponse);
        ...
    }