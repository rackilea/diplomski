public int Do()
{
  JSObject win = (JSObject) JSObject.getWindow(this);
  JSObject doc = (JSObject) win.getMember("document");
  JSObject fun = (JSObject) win.getMember("DumberTest");
  JSObject loc = (JSObject) doc.getMember("location");
  String href = (String) loc.getMember("href");
  String[] arguments = { href, fun.toString() };
  win.call("DumbTest", arguments);
  return fun.toString().length();
}