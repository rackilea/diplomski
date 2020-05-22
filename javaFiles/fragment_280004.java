// object to allow applet to invoke Javascript methods
protected static JSObject appletWindowJSObject = null;

appletWindowJSObject = JSObject.getWindow(this);

 //Call your javascript method on the page and pass it something
 appletWindowJSObject.call("myJavascriptMethod", "This is what I am passing");