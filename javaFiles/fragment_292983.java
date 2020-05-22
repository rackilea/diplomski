JSONArray activityjson = new JSONArray(jsonObject.getString("activity"));
  List<Map<String, String>> data = new ArrayList<Map<String, String>>();
  for (int i = 0; i < activityjson.length(); i++) {
    Map<String, String> activity = new HashMap<String, String>();
                            JSONObject obj = (JSONObject) activityjson.get(i);

                            activity.put("ID", obj.get("ActivityID").toString());
                            activity.put("Name", obj.get("ActivityName").toString());
                            activity.put("Desc", obj.get("ActivityDesc").toString());
                            activity.put("Req", obj.get("ActivityReq").toString());
                            activity.put("Start", obj.get("StartDate").toString());
                            activity.put("End", obj.get("EndDate").toString());
                            activity.put("Location", obj.get("Location").toString());
                            activity.put("Points", obj.get("AwardPoints").toString());
                            data.add(activity);
                        }
// now access activity.get(0), activity.get(1), ...