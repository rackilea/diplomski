for (int i = 0; i<jsonArray.length(); i++){
    JSONObject classObj = jsonArray.getJSONObject(i);

    Classes dailyClasses = new Classes();
    dailyClasses.setClass_id("" + classObj.getString("id"));
    dailyClasses.setClass_name("" + classObj.getString("name"));
    dailyClasses.setClass_room("" + classObj.getString("room"));
    dailyClasses.setClass_day("" + classObj.getString("day"));
    dailyClasses.setClass_time("" + classObj.getString("time"));

    classList.add(dailyClasses);
}