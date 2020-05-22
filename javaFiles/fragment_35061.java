import java.util.*;

public class Lists_of_values {
    public static List<String> circumstances = Arrays.asList("Medical", "Maternity", "Bereavement", "Other");
    public static List<String> interruptions = Arrays.asList("Awaiting results", "Courses not available", "Fieldwork", "Health reasons", "Internship with stipend", "Other");

    private static Map<String, List<String>> lists = new HashMap<>();
    static {
        lists.put("circumstances", circumstances);
        lists.put("interruptions", interruptions);
    }

    public static List<String> getList(String name) {
        return lists.get(name);
    }
}