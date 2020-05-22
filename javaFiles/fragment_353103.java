JsonParser jp = new JsonParser();  // create instance for the jsonparse class

    String caregiverID = MainActivity.confirm.toString();

    JSONObject param = new JSONObject();
    JSONObject job =  new JSONObject();
    try {
        param.put("username", yourUserNAme);
        job = jp.getJSONFromUrl(param, yourURL);