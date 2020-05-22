public class MyClass extends JApplet {
    public void init() {
        JSObject window = JSObject.getWindow(this); 
        Object[] args = new String[] { "bar" }; 
        window.call("foo", args); 
    }
}