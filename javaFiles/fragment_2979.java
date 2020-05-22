abstract class AbstractTest {
   public abstract ISubject subject();

   //...

   public CSubject generateParticularSubject() {
     return new CSubject();
   }
 }