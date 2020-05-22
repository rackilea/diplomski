public class MyClass {
    private String myString; // this variable can only be directly access from within MyClass scope.

    // constructor - called when an instance of MyClass is initialized ( e.g. MyClass myClass = new MyClass(); )
    public MyClass(){
        myString = "Hello world!"; // init my_string        
    }

    // Can access variable from within class to print
    public void printMyString(){
        System.out.println(myString);
    }

    // Can set private class variables
    public void setMyString(String input){
        this.myString = input; // set value
    }

    // Can get (return) private class variables
    public String getMyString(){
        return myString; // get value
    }
}