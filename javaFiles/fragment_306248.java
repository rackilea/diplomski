package com.example;
public class Layout extends VLayout() {
    private String nonStaticVar = "nonStaticVar";
    public Layout() {
        declareMethod(this);
    }

    //Method which declares non-static method in javascript
    public native void declareMethod(Layout layout) /*-{
        var layout = layout;
        $wnd.doSomething = function(someString) {
            layout.@com.example.Layout::doSomething(Ljava/lang/String;)(someString);
        }
    }-*/;

    //Non static method which is being called
    public String doSomething(String someString) {
        //Do something, e.g. set var in this instantiated class, or output stuff
        this.nonStaticVar = someString;
        Window.alert(someString);
    }
}