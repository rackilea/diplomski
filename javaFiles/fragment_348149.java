Subject currentUser = null;
if (parameters.containsKey("session")) {
    sId = parameters.get("session");
    currentUser = new Subject.Builder().sessionId(sId).buildSubject();
} else {
    currentUser = SecurityUtils.getSubject();
}