class UserObjectSerializer {

  Map<String, String> tagValue = new Map<String, String>();

  public UserObjectSerializer(User user) {
      tagValue["firstname"] = user.getFirstname();
      tagValue["lastname"] = user.getLastname();
      tagValue["dob"] = user.getDob();
  }

  public printXml() {
    // browse your Map and prints your <keys>values</keys>
    Set key = tagValue.keySet();
    Iterator it = key.iterator();
    while(it.hasNext()) {
       String tag = it.next();
       String value = tagValue.get(key);
       System.out.println("<" + tag + ">" + value + "</" + tag + ">");
    }
  }
}