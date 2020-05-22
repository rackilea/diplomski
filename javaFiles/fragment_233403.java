@Override
 public void onResponse(JSONObject response)
 {
     Log.d(TAG + ": ", "somePostRequest Response : " + response.toString());
     // here you need to parse to JSON to a list and then call...
     List<Item> items = parseResponse(response);
     myAdapter.updateDataSet(items);
  }