import java.util.ArrayList;

public class StringSplit {

    public static void main(String[] args) {
        String[] seperatedStr = null;
        int fourthStrIndex = 0;
        String modifiedStr = null, finalStr = null;
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("31451  CID005319044    　　15939353　　    C8H14O3S2    beta-lipoic acid   C1C[S@](=O)S[C@@H]1CCCCC(=O)O ");
        strList.add("12232 COD05374044 23439353   C924O3S2   saponin       CCCC(=O)O ");
        strList.add("9048   CTD042032 23241 C3HO4O3S2  Berberine    [C@@H]1CCCCC(=O)O ");

        for (String item: strList) {
            seperatedStr = item.split("\\s+");
            fourthStrIndex = item.indexOf(seperatedStr[3])  + seperatedStr[3].length();
            modifiedStr = item.substring(fourthStrIndex, item.length());
            finalStr = modifiedStr.substring(0, modifiedStr.indexOf(seperatedStr[seperatedStr.length - 1]));
            System.out.println(finalStr.trim());
        }
    }
}