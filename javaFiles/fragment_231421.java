abstract class AbstractParent // this is the template class
{
    // this is the template method that enforces an order of method execution
   final void executeIt()
   {
     doBefore(); // << to be implemented by subclasses
     doInTheMiddle() // also to be implemented by subclasses
     doLast(); // << the one you want to make sure gets executed last
   }

   abstract void doBefore();
   abstract void doInTheMiddle();
   final void doLast(){ .... }
}

class SubA extends AbstractParent
{
   void doBefore(){ ... does something ...}
   void doInTheMiddle(){ ... does something ...}
}

class SubB extends SubA
{
   void doBefore(){ ... does something different ...}
}