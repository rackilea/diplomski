public class Book extends JavaScriptObject {
   public static Book instance; // The global

   protected Book(){}

   public final native String getName()/*-{ 
      return this.name; 
   }-*/;

   public final native void setName(String name)/*-{
      this.name = name; 
   }-*/;
}