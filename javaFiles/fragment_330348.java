public class C2
{
 //all fields and stuff
 public void callerFunction()
{
    C1 obj=new C1();
     //created an object of class C1
    obj.hello(5);
    C1.hey(10);
     //only class name is required while calling static methods.
}
}