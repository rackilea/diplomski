import java.util.*;

public class Question19369420 {
    private static String search;

    public static void main(String[] args) {

        search = "sgfastol";

        List<String> input = new ArrayList<>();
        input.add("2013-10-15 08:28:31,514~stQAEFV~establishAgreementSummary~2~5234 ms.");
        input.add("2013-10-15 08:28:22,442~sgFASTOL~retrieveParty~2~1776 ms.");
        input.add("2013-10-15 08:27:37,333~sfRPDesktop~modifyParty~2~1744 ms.");
        input.add("2013-10-15 08:28:14,719~sgITL~retrieveParty~2~1702 ms.");
        input.add("2013-10-15 08:28:27,755~sgFASTOL~establishParty~2~1682 ms.");
        input.add("2013-10-15 08:28:39,677~sfRPDesktop~retrieveParty~2~1679 ms.");
        input.add("2013-10-15 08:27:55,768~sgBLD~searchAgreementSummary~2~1495 ms.");
        input.add("2013-10-15 08:27:46,272~sgCSCWB~searchAgreementSummary~1~1402 ms.");
        input.add("2013-10-15 08:27:49,660~sfRPDesktop~retrieveParty~2~1395 ms.");
        input.add("2013-10-15 08:27:39,547~sgHERYN~searchAgreementSummary~1~1341 ms.");
        input.add("2013-10-15 08:27:47,028~sgCSCWB~retrieveCustomerProfile~1~1323 ms.");
        input.add("2013-10-15 08:27:29,795~sgFASTOL~retrieveParty~2~1296 ms.");
        input.add("2013-10-15 08:27:44,520~sfRPDesktop~retrieveParty~2~1290 ms.");
        input.add("2013-10-15 08:28:04,398~sgFASTOL~retrieveParty~2~1284 ms.");

        String action = "ptnr";
        ArrayList<String[]> results = null;
        if ("time".equals(action)) {
            results = searchLogs(input, 0);
        } else if ("ptnr".equals(action)) {
            results = searchLogs(input, 1);
        } else if ("srv".equals(action)) {
            results = searchLogs(input, 2);
        }

        if (results != null) {
            System.out.println("before sort");
            print(results);
            Collections.sort(results, createComparator(4));
            System.out.println("after sort");
            print(results);
        }

    }

    public static Comparator<String[]> createComparator(final int field) {
        return new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                return a[field].compareTo(b[field]);
            }
        };
    }

    public static void print(List<String[]> list) {
        for (String[] item : list) {
            System.out.println(String.format("  %s %s %s %s %s ms.", item[0], item[1], item[2], item[3], item[4]));
        }
    }

    public static ArrayList<String[]> searchLogs(List<String> input, int index) {
        System.out.println("Searching on Partner ID for " + search + "....");
        ArrayList<String[]> results = new ArrayList<>();
        for (String str : input) {
            results.add(str.split("~"));
        }
        ArrayList<String[]> finalResults = new ArrayList<>();
        for (String[] searchItems : results) {
            String lowerField = searchItems[index].toLowerCase();
            if (lowerField.equals(search)) { // or lowerField.contains(search)
                finalResults.add(searchItems);
            }
        }
        return finalResults;
    }
}