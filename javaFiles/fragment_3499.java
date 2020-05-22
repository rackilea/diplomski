//Init
ArrayList<String> linkArrayList = new ArrayList<String>();
JSONArray managerArray = new JSONArray(yourString);

//Iterate over the top-level array
for( int count = 0, max = managerArray.length(); count < max; count++ ) {

    //Get the current JSONObject & the link array
    JSONObject managerObject = managerArray.optJSONObject(count);
    JSONArray linkArray = managerObject.getJSONArray("screenshots");

    //Iterate over the screenshots
    for( 
        int subCount = 0, maxSubCount = linkArray.length(); 
        subcount < maxSubCount; 
        subCount++ 
    ) {

        //Let's store the String
        linkArrayList.add( linkArray.getString( subCount );

    }

}