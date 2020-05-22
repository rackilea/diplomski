function RegisterCallback(cbFunction)
{
  var callback = cbFunction.toString(); // We get JS code
  var callbackName = /^function (\w+)\(/.exec(callback);
  document.Applet.RegisterCallback(callbackName[1]);
}