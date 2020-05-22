public List<Map<String, String>> getReportees(String idOfEmp) {
    if (jsonarr_s.size() <= 0)
        return Collections.emptyList();

    List<Map<String, String>> res = new ArrayList<>();

    for (int i = 0; i < jsonarr_s.size(); i++) {
        Map<String, String> map = new HashMap<>();
        String names = String.valueOf(((JSONObject)jsonarr_s.get(i)).get("displayName"));
        String userid = String.valueOf(((JSONObject)jsonobj_1.get("jive")).get("username"));
        map.put(names, userid);
        map.putAll(count.getJiraCount(userid));

        res.add(map);
    }

    return res;
}