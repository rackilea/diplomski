class A //Super class A
{
    void callme()   // method callme() that'll be overwritten next in subclasses
    {
        System.out.println("Im in the class A"); 
    }
}  
class B extends A   //Subclass B  inherited from A
{            
    void callme()   //method callme() of Super class A is over-hided here
    {
        System.out.println("Im in the class B"); 
    } 
}  
class C extends B            //Subclass C, inherited from B
{
    void callme()    // this time B subclass method callme() is over-hided
    {
        System.out.println("Im in the class C"); 
    }
}  

//Now suppose, during you development phase at some time, you don't want to use over-ridden methods, here is DMD to help you out at run time.

public class Dispatch
{ 
    public static void main(String args[])
    { 
        A a = new A(); 
        B b = new B(); 
        C c = new C(); 
        A r;
        // r is a reference to class A
        // this reference should be assigned to each type of object and called at
        // run time without compiling.
        r = a; 
        r.callme(); 
        r = b; r.callme(); 
        r = c; r.callme(); 
    } 
}