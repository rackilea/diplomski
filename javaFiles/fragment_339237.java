import java.util.*;

public class Test {
    public static void main(String... args) {
        List<String> list = new ArrayList<>();
        list.add("zzz, abc");
        list.add("yy, ghi");
        list.add("x, def");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return filter(lhs).compareTo(filter(rhs));
            }

            private String filter(String s) {
                // consider the first comma
                return s.replaceFirst("^.*?, ", "");
                // to consider the last comma instead:
                // return s.replaceFirst("^.*, ", "");
            }
        });
        for (String s : list)
            System.out.println(s);
    }
}