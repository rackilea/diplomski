public class MyClass{
   @Autowired
   private Object implicitObject;

   public final Object implicitObject() {return implicitObject;}
}

public class MySubClass extends MyClass{
   public void doSomething(){
         implicitObject().doSomething(); 
   } 
}