public  JSONArray findShortest(JSONObject json_object, final String sortByThisElement) throws JSONException {
......

        ......

        try {
            valA = String.valueOf(a.get(sortByThisElement));
            valB = String.valueOf(b.get(sortByThisElement));
        } catch (JSONException e) {
            //do something
        }
        ......
    }
});