Object obj;
try {

    obj = parser.parse(sCurrentLine);
    JSONArray jsonArray = (JSONArray) obj;
    for(obj : jsonArray){//not sure of the exact syntax, I don't have an IDE in front of me.
        JSONObject jsonObject = (JSONObject)obj;
        JSONObject realTitle = (JSONObject)jsonObject.get("0");
        String name = (String) realTitle.get("title");
    }


} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}