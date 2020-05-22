Map<String,String> data  = new HashMap<String,String>();
data.put("firstname", "George");
data.put("lastname", "Clooney");
data.put("email", "George@xyz.com");
data.put("password", "Dontguess");
JoinNow(data);

protected void JoinNow(Map<String,String> data) {
    firstNameElement.sendKeys(data.get("firstname"));
    lastNameElement.sendKeys(data.get("lastname"));
    emailElement.sendKeys(data.get("email"));
    passwordElement.sendKeys(data.get("password"));
}