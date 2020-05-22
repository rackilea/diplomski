import java.io.*;
import java.util.*;

/**
 * Created by peter on 10/07/16.
 */
public class GroupedRelationBuilder {

    public static List<List<Integer>> load(File file) throws IOException {
        Map<Integer, Group> idToGroupMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            for (String line; (line = br.readLine()) != null; ) {
                String[] parts = line.split(";");
                Integer source = Integer.parseInt(parts[0]);
                Integer target = Integer.parseInt(parts[1]);
                Group grp0 = idToGroupMap.get(source);
                Group grp1 = idToGroupMap.get(target);
                if (grp0 == null) {
                    if (grp1 == null) {
                        Group grp = new Group();
                        List<Integer> list = grp.ids;
                        list.add(source);
                        list.add(target);
                        idToGroupMap.put(source, grp);
                        idToGroupMap.put(target, grp);
                    } else {
                        grp1.ids.add(source);
                        idToGroupMap.put(source, grp1);
                    }
                } else if (grp1 == null) {
                    grp0.ids.add(target);
                    idToGroupMap.put(target, grp0);
                } else {
                    grp0.ids.addAll(grp1.ids);
                    grp1.ids = grp0.ids;
                }
            }
        }
        Set<List<Integer>> idsSet = Collections.newSetFromMap(new IdentityHashMap<>());
        for (Group group : idToGroupMap.values()) {
            idsSet.add(group.ids);
        }
        return new ArrayList<>(idsSet);
    }

    static class Group {
        List<Integer> ids = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("deleteme", "txt");
        Set<String> pairs = new HashSet<>();
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("source;target");
            Random rand = new Random();
            int count = 1000000;
            while (pairs.size() < count) {
                int a = rand.nextInt(count);
                int b = rand.nextInt(count);
                if (a < b) {
                    int t = a;
                    a = b;
                    b = t;
                }
                pairs.add(a + ";" + b);
            }
            for (String pair : pairs) {
                pw.println(pair);
            }
        }
        System.out.println("Processing");
        long start = System.currentTimeMillis();
        List<List<Integer>> results = GroupedRelationBuilder.load(file);
        System.out.println(results.size() + " took " + (System.currentTimeMillis() - start) / 1e3 + " sec");
    }
}