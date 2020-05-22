public void onModuleLoad() {
  int i = 1;
  do {
    String id = "marker" + i;
    RootPanel rp = RootPanel.get(id);
    if (rp == null) {
      break;
    }
    rp.add(new MyWidget(getContextData(id)));
    i++;
  } while (true);
}

native String getContextData(String id) /*-{
  return $wnd.myConfig[id];
}-*/;