class Foo {
    static {
         System.out.println("loaded Foo");
    }
}

//running this will print "loaded Foo"
Class.forName("Foo");