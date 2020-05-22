public static void main(String[] args){
    try {
        //Simple Json Object
        JSONObject  testObj= new JSONObject("{name: sam,city: SF,number:0017100000000,message: xyz has occurred}");

        System.out.println("Name in json\t" +testObj.get("name"));
        System.out.println("City in json\t" +testObj.get("city"));

        //If you want to get from array
        JSONObject arrObj = new JSONObject("{interests : [{interestKey:Dogs}, {interestKey:Cats}]}");

        List<String> list = new ArrayList<String>();
        JSONArray array = arrObj.getJSONArray("interests");
        for(int i = 0 ; i < array.length() ; i++){
            list.add(array.getJSONObject(i).getString("interestKey"));
        }


    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}