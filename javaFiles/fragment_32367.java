ArrayList<String> listSession = new ArrayList<String>(); 
for(int u=1; u < k+1; u++) {
    String str = Integer.toString(u);

    JSONArray arrTime=(JSONArray)mergedJSON2.get(str);
    JSONObject objSession;
    StringsessionName;
    for (Object ro : arrTime) {

        objSession = (JSONObject) ro;
        sessionName = String.valueOf(objSession.get("sessionID"));

        if (!listSession.contains(sessionName)) {
            listSession.add(sessionName);
        }
    }
}