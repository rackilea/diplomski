public class abstract Type
{ 
   public static final Type UNKNOWN   = registerStd("UNKNOWN");
   ...
   public static final Type TIMER     = registerStd("TIMER");

   // use this to keep track of all the types
   private static final List<Type> REGISTERED = ...

   //This will do your switch statement for you, implemented by 
   // anonymous subclasses
   public abstract void dispatch(Type onMe);

   // here's how you make the standard ones
   private static Type registerStd(String name)
   {
       Type heresOne = new Type(name) 
       { 
          // note, it's a no-op
          public void dispatch(DoStuffer algorithm) {} 
       };
       REGISTERED.add(heresOne);
       return heresOne;
   }

   //here's how you make the non-standard ones
   public static Type registerNew(String name)
   {
       Type heresOne = new Type(name) 
       {
          public void dispatch(DoStuffer algorithm) {algorithm.execute(this)} 
       };
       REGISTERED.add(heresOne);
       return heresOne;
   }

}

public interface DoStuffer 
{
   public void execute(Type onMe);
}

//Then your code becomes
Type newType = Type.registerNew("NewType");

newType.dispatch
(
     new DoStuffer() 
     {
        public void algorithm(Type forMe) { ... } 
     }
);