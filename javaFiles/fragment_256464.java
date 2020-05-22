class Foo {
     public ArrayList<Bar> myBars;
     void addBar(Bar bar) {
         myBars.add(bar);
     }
}

class Bar {
     public Foo myFoo;

     public Bar(Foo foo) {
         myFoo = foo;
         foo.addBar(this);
     }
}