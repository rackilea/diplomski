ArrayList<JSONObject> receivingArr;
Bundle receivingListOfStrings = getIntent().getExtras();
ArrayList<String> list = receivingListOfStrings.getStringArrayList("sending_list");
for (int i = 0; i < receivingListOfStrings.length(); i++) {
    receivingArr.add( new JSONObject( receivingListOfStrings.get(i) ) );
}