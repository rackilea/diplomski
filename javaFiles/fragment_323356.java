class MyObject() {
  String testJson;
  String userId;

  public void setTestJson(String testJson) {
    this.testJson=testJson;
  }
  public String getTestJson() {
    return testJson;
  }
  ... Same for userId
}

And then create a GSON object:

class SomeClass {
  public void parseMyJson(String json) {
    Gson gson=new Gson();
    MyObject mo=gson.fromJson(json,MyObject.class);
  }
}