...
new MockUp<Base>() {
    @Mock int getX() { return 10;}

};
Derived d = new Derived();
System.out.println(plot.getWidth());  // prints 10
...