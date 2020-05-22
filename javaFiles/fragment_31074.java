private class MyTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... params) {

        String content = HttpManager.getData(params[0]);
        return content;
    }




//-----------------------THIS IS WHERE THE ISSUE IS HAPPENING---------------------------
    @Override
    protected void onPostExecute(String result) {
        hideDialog();
        String parseResult = InfoJSONResultParser.parseFeed(result);

        importerArray = OrderInformationParser.orderParser(result);

        if (parseResult.equals("ok")) {
            //Returns the Array with the JSON info already parsed.
            List<Bean> myList = new ArrayList<>(); //<---***How to populate this***




//***With  the information from these two String arrays.***
            String[] descriptionArray = OrderInformationParser.orderParser(result);
            String[] photoArray = PhotoParser.photoParser(result);

        myList = populateBeanList(myList,descriptionArray, photoArray);

        //This creates and executes the list
        list = (ListView)findViewById(R.id.orderListView);


        //***So i can then transfer over to this adapter***
        MyAdapter adapter = new MyAdapter(MainActivity.this, myList);
        list.setAdapter(adapter);


    } else {
        findViewById(R.id.nullOrders).setVisibility(View.VISIBLE);
    }
}