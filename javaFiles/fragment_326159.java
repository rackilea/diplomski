class SuperClass {
}

class MyClass1 extends SuperClass {
}

class MyClass2 extends SuperClass {
}

private SuperClass myMethod(String parameter) {
    SuperClass sc = null;
    //just trying some code, this could be replaced for your logic
    if (parameter.equals("1")) {
        sc = new MyClass1();
    } else {
        sc = new MyClass2();
    }
    return sc;
}

private void myOtherMethod(String parameter) {
    //some code here...
    SuperClass sc = myMethod(parameter);
    if (sc != null) {
        //securing the upcast...
        if (sc instanceof MyClass1) {
            //logic of MyClass1 instance...
        }
        if (sc instanceof MyClass2) {
            //logic of MyClass2 instance...
        }
    }
    //more logic over here...
}