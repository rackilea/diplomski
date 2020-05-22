JSObject window = JSObject.getWindow(this);

// invoke JavaScript function
String result = "<table><tr><th>Column1</th><th>Column2</th></tr><tr><td>" 
+ field1 + "</td><td>" + field2 + "</td></tr></table>";
window.call("writeResult", new Object[] {result});