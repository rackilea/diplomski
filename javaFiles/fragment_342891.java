public void Call(String message)
{
  JSObject win = (JSObject) JSObject.getWindow(this);
  String[] arguments = { "Call with String", message };
  win.call("DumbTest", arguments);
}

public void Call(JSObject jso)
{
  JSObject win = (JSObject) JSObject.getWindow(this);
  String[] arguments = { "Call with JSObject", jso.toString() };
  win.call("DumbTest", arguments);
}