package app.client.local;

class MyClass {
  public void populate() {
  }
}

class MyPage {
  public static native void update(MyClass instance) /*-{
    instance.@app.client.local.MyClass::populate()();
  }-*/;
}