public String getTitleForDate(String searchDate) {
    for ( int i=0; i<array.length; i++) {
        JSONObject json = array.getJSONObject(i);
        String date = json.optString("date");
        if(date != null && searchDate.equals(date)) {
            return json.optString("title");
        }
    }
    return null;
}