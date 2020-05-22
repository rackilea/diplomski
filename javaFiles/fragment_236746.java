public static native String javaMethod(JavaScriptObject obj, String a, String b)  /*-{
    var test = null;
    test = ... ;

    var testString = null;
    testString = test.jsMethod(a, b);
    return testString;
}-*/;