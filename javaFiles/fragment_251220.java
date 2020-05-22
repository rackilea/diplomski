public class Words{
   public Word[] wordsArray;
   private String locale = "de";
   private Context c;
   public Words(String locale, Context paramContext) {
      if (locale != null ) {
         this.locale = locale;
      }
      c = paramContext;
   }
// Rest of code ok.
//
// Remove the Context c variable further on as it is declared above!
}