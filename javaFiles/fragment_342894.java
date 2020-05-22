String callbackFunction;
public void RegisterCallback(String functionName)
{
  callbackFunction = functionName;
}
void UseCallbackFunction()
{
    if (callbackFunction == null) return;
    JSObject win = (JSObject) JSObject.getWindow(this);
    win.call(callbackFunction, null);
}