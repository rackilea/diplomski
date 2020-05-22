String rules=helper.getRules();
System.out.println("====Rulses=====:"+rules);
try {
    // create the json array from String rules
    JSONArray jsonRules = new JSONArray(rules);
    // iterate over the rules 
    for (int i=0; i<jsonRules.length();i++){
        JSONObject obj = jsonRules.get(i);
        System.out.println("====obj===="+obj);

        String id = obj.getString("id");
        System.out.println("===id is===: "+id);
    }
} catch (JSONException e){
    e.printStackTrace();
}