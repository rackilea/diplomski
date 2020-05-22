import java.util.*;
public class MultiMapExample {
    public static void main(String[] args) {
        Object[][] arr = {
            { "IBM",    new String[] { "Joe", "Jack", "Carol"   }},
            { "MS",     new String[] { "Jack", "Andy", "Carol" }},
            { "Google", new String[] { "Bob", "Alice", "Carol"  }},
        };
        Map<String,Set<String>> employerMap =
            new HashMap<String,Set<String>>();

        for (Object[] data : arr) {
            String employer = (String) data[0];
            String[] workers = (String[]) data[1];
            for (String worker : workers) {
                Set<String> employers = employerMap.get(worker);
                if (employers == null) {
                    employerMap.put(worker, employers = new HashSet<String>());
                }
                employers.add(employer);
            }
        }

        for (String worker : employerMap.keySet()) {
            System.out.println(worker + " works for " + employerMap.get(worker));
        }
    }
}