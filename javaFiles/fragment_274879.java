public class Collator {

   public static final Collator getInstance() {
      return instance;
   }

   private static final Collator instance = new Collator();

   public native int compare( String source, String target ); /*-{
     return source.localeCompare( target );
   }-*/
}