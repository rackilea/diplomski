import  java.util.regex.Pattern;
import  java.util.regex.Matcher;

 /**
    <P>{@code java OverlappingSubstringsXmpl}</P>
  **/
 public class OverlappingSubstringsXmpl  {
    public static final void main(String[] igno_red)  {
      String sToFind = "cdc";
      String sToSearch = "cdcdcdedcdc";

      System.out.println("Non regex way:");

         int iMinIdx = 0;
         while(iMinIdx <= (sToSearch.length() - sToFind.length()))  {
            int iIdxFound = sToSearch.indexOf(sToFind, iMinIdx);

            if(iIdxFound == -1)  {
               break;
            }

             System.out.println(sToFind + " found at index " + iIdxFound);

            iMinIdx = iIdxFound + 1;
         }

      System.out.println("Regex way:");

         Matcher m = Pattern.compile(sToFind, Pattern.LITERAL).matcher(sToSearch);
         boolean bFound = m.find();
         while (bFound) {
            System.out.println(sToFind + " found at index " + m.start());
            bFound = m.find(m.start() + 1);
         }
   }
}