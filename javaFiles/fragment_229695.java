import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DateSorter {

    static class Entry implements Comparable<Entry> {
        String id;
        int num;
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        public Entry(String id, int num, String date) throws ParseException {
            this.id = id;
            this.num = num;
            this.date = sdf.parse(date);
        }

        @Override
        public int compareTo(Entry o) {
            return date.compareTo(o.date);
        }

        @Override
        public String toString() {
            return id + '\'';
        }
    }

    public static void main(String[] args) throws ParseException {
        String s1 = "a1 5 2014-12-05";
        String s2 = "a2 10 2014-12-06";
        String s3 = "a3 5 2014-12-04";

        String[] split = s1.split(" ");

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(split[0], Integer.parseInt(split[1]), split[2]));
        split = s2.split(" ");
        entries.add(new Entry(split[0], Integer.parseInt(split[1]), split[2]));
        split = s3.split(" ");
        entries.add(new Entry(split[0], Integer.parseInt(split[1]), split[2]));

    Collections.sort(entries, new Comparator<Entry>() {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o2.compareTo(o1);
        }
    });

        System.out.println(entries);
    }
}