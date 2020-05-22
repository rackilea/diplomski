import java.util.Comparator;

public class MyComparator implements Comparator<String> {

    @Override
    public int compare(String arg0, String arg1) {

        int indexOf = arg0.indexOf("-");
        String substring = arg0.substring(0, indexOf-1);
        int indexOf1 = arg1.indexOf("-");
        String substring1 = arg1.substring(0, indexOf1-1);
        return Integer.valueOf(substring) - Integer.valueOf(substring1);
    }

}


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> entries = new ArrayList<String>();
        entries.add("0 - name1");
        entries.add("1000 - name2");
        entries.add("1004 - name4");
        entries.add("1002 - name3");
        entries.add("10000 - name5");
        entries.add("2000 - name5");

        Comparator<String> comparator = new MyComparator();
        Collections.sort(entries, comparator );

        for (String e : entries){
            System.out.println(e);
        }

    }
}