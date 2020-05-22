package app.client.local;
class MyPage {

  public static native void update() /*-{
    @app.client.local.MyPage::populate()();
  }-*/;

  public static void populate() {
  }
}