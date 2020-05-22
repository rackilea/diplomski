public class Name {

   private String givenName;
   private int[]  ranks = new int[11];
   static List<Name> list = new ArrayList<Name>();

   public static void main( String[] args ) {

      loadFile();
   ......