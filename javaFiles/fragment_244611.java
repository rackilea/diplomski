private static void insertValue(int index, List<JSONObject> linkedList2,
                                double ID, double age, String t) throws JSONException {
    JSONObject jo1  = new JSONObject();
    jo1.put("ID", ID);
    jo1.put("Age", age);
    JSONObject jo2 = new JSONObject();
    jo2.put("type", t);
    jo2.put("DB", jo1);
    linkedList2.add(index, jo2);
}