public class Salutation implements HasDisplayText {

   private String displayText;

   private Salutation(String displayText) {
       this.displayText = displayText;
   }

   @Override
   public String getDisplayText() {
       return displayText;
   }

   public static Collection<Salutation> loadSalutations(String xml) {
      //parse, instantiate, and return Salutations
   }
}