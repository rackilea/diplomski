class Result {
  int id;
  String updated_at;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  // setter should take a string (as it is in the JSON)
  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }

  // the getter should return a Date to map with MyClass
  public Date getUpdated_at() {
    Date d = null;
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
      d = format.parse(updated_at);
    } catch(ParseException e) {
      e.printStackTrace();
    }
    return d;
  }
}