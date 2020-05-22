public class Foo {

static {
    System.loadLibrary("Foo");
}

public static void main(String[] args) {

    ReturnObject returnObject = new ReturnObject();
    returnObject.list = new ArrayList<>();

    Foo foo = new Foo();
    foo.someFunction(returnObject);
    System.out.println("size is " + returnObject.list.size());

    foo.someFunction(returnObject);
    System.out.println("size is " + returnObject.list.size());

    foo.someFunction(returnObject);
    System.out.println("size is " + returnObject.list.size());

    // we have three element added from JNI
    for (String string : returnObject.list.get(2)) {
        System.out.println(string);
    }
}

public native void someFunction(ReturnObject returnObject);
}