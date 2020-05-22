try {

    JSONObject jsonObject=new JSONObject(result);

    JSONObject currentJSONObject = jsonObject.getJSONObject("current");
    JSONObject conditionJSONObject = currentJSONObject.getJSONObject("condition");

    String text = conditionJSONObject.getString("text");
    String feelslike_c = currentJSONObject.getString("feelslike_c");

    Log.i("website content", "text: " + text);
    Log.i("website temp", "feelslike_c: " + feelslike_c);

} catch (Exception e){
}