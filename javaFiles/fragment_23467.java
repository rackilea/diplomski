@Component 
public class YImpl implements Y {

   @Activate
   void activate() { /* only called when X is registered */ }
   @Reference
   void setX( X x ) {
      this.x = x;
   }