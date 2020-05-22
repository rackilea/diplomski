final static String AT_PUBID = "YOUR-PUBID";
final static String AT_URL = "https://s7.addthis.com/js/300/addthis_widget.js#domready=1";

public void onModuleLoad() {
  setAddthisId(AT_PUBID);
  ScriptInjector.fromUrl(AT_URL).inject();
}

private static native void setAddthisId(String id) /*-{
  $wnd.addthis_config = $wnd.addthis_config||{};
  $wnd.addthis_config.pubid = id;
}-*/;