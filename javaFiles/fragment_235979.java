Base pureBase = new Derived();
B b = pureBase.foo(); //which returns class D

if (b instanceof D) {
   //sure, it is, do some other logic
}