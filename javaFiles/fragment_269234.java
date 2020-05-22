for (Object json : jsonArray) {
    printJSONOBject((JSONObject) json)
}

private void printJSONOBject(JSONObject jsonObject) {
    for (Object keyObj : jsonObject.keySet()) {
        String key = (String) keyObj;
        Object valObj = jsonObject.get(key);
        if (valObj instanceof JSONObject) {
            printJSONOBject((JSONObject) valObj);
        } else {
            System.out.println(key + " : " + valObj);
        }
    }
}