ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Inventory");
    query.whereEqualTo("productName", Capris);
    query.findInBackground(new FindCallback<ParseObject>() {
        public void done(List<ParseObject> list, ParseException e) {
            if (e != null) {
            for (ParseObject myData : list) {
            String user = (String) myData.get("productPrice");
            }
        }
        else {
          Toast.makeText(getApplicationContext(),
                         "Error: " + e.getMessage(),
                          Toast.LENGTH_SHORT).show();

              }
         }
    }