class AbstractClass {
   AbstractClass(){ /* useful implementation */ }
}

class ConcreteClass1 extends AbstractClass {
     ConcreteClass1(){ super(); /* useful implementation */ }
     ConcreteClass1(boolean skip){ super(); }
}
class CustomizedClass1 extends ConcreteClass1 {
     CustomizedCLass1(){ super(true); /* useful implementation */ }
}