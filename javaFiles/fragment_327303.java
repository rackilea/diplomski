public static final class User {
    private final String userName;
    private final String displayName;
    private final Map<?, ?> jiraCount;  // do not know what data is returned with `count.getJiraCount()`

    public User(String userName, String displayName, Map<?, ?> jiraCount) {
        this.userName = userName;
        this.displayName = displayName;
        this.jiraCount = jiraCount;
    }
}

public List<User> getReportees(String idOfEmp) {
    if (jsonarr_s.size() <= 0)
        return Collections.emptyList();

    List<User> res = new ArrayList<>();

    for (int i = 0; i < jsonarr_s.size(); i++) {
        String userName = (((JSONObject)jsonobj_1.get("jive")).getString("username"));
        String displayName = ((JSONObject)jsonarr_s.get(i)).getString("displayName");
        Map<?, ?> jiraCount = count.getJiraCount(userid);
        res.add(new User(userName, displayName, jiraCount));
    }

    return res;
}