Sub1(){
    super();               // <== Default super() call, inserted by the compiler
    three=(int) Math.PI;   // <== Instance initializers are really inserted
                           // into constructors by the compiler
    super.printThree();
}