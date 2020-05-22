function CallJava()
{
  document.Applet.Call("Does it work?");
  document.Applet.Call(function () { alert("It works!"); });
  document.Applet.Call(DoSomething); // A simple parameterless JS function
  document.Applet.Call(window.location);
}
function DumbTest(message, value)
{
  alert("This is a dumb test with a message:\n" + message + "\n" + value);
}