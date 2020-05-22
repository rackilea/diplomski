public class AssetManager {
   ...
   private IContentProcessor contentProcessor
   ...

   // This method to be invoked by client to set (a.k.a inject) customer implemenation
   public void setContentProcesssor(IContentProcessor c) {
      this.contentProcessor = c;
   }
}