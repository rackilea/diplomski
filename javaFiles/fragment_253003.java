class Parent{
    void doStuff(){
       System.out.println("parent class");
    }
    void asd(){
    doStuff();
    }
 }
 class Child extends Parent(){

       @Override
       void doStuff(){
         //super.asd();
         System.out.println("child class");
    }
 }