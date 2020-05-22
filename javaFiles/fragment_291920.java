public  JSONArray findShortest(JSONObject json_object, String sortByThisElement) throws JSONException {
......

        ......
        System.out.println("jsonList = " + jsonList.toString());
        final String sortByThis = sortByThisElement;//note this should be add before Collections.sort 
        ........
        try {
            valA = String.valueOf(a.get(sortByThis));
            valB = String.valueOf(b.get(sortByThis));
        } catch (JSONException e) {
            //do something
        }
        ......
    }
});