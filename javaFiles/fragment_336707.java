String result = getLargeJSONString(...);
JSONArray results = new JSONArray(result);
try(Writer output=new OutputStreamWriter(new FileOutputStream(outputFile), "UTF8")) {
    for (int i = 0; i < results.length(); i++) {
        JSONObject cleanedResult = JSONSanitizer.sanitize((JSONObject) results.get(i));
        output.write(cleanedResult.toString());
        output.write('\n');
    }
}