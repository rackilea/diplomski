package com.company;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo("bar");
        foo.obj.hello();
    }
}

class Foo {
    Ba obj;

    Foo(String str) { // Constructor
        if (str.equals("bar")) {
            this.obj = new Bar();
        } else {
            this.obj = new Baz();
        }
    }
}

interface Ba {
    void hello();
}

class Bar implements Ba {
    public void hello(){
        System.out.println(" Hello Bar");
    }
}

class Baz implements Ba {
    public void hello(){
        System.out.println(" Hello Baz");
    }
}