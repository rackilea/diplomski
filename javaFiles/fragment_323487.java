public class Migrator {
    private static final String KEY1 = "post_tran_id";
    private static final String KEY2 = "post_tran_cust_id";

    void migrate(String post_tran, String post_tran_cust) throws IOException {
        Map<String, Map<String, String>> h1 = loadFile(post_tran, KEY1);
        Map<String, Map<String, String>> h2 = loadFile(post_tran_cust, KEY2);

        PrintStream out = new PrintStream("final.tbl");

        for (Map.Entry<String, Map<String, String>> entry : h1.entrySet()) {
            Map<String, String> data = entry.getValue();
            String k = data.get(KEY2);
            if (k != null && h2.containsKey(k.trim())) {
                print(out, KEY1, data.get(KEY1));
                print(out, KEY2, data.get(KEY2));
                // Print remaining rows in any order
                for (String key : data.keySet()) {
                    if ( ! key.equals(KEY1) && ! key.equals(KEY2) ) {
                        print(out, key, data.get(key));
                    }
                }
                data = h2.get(k.trim());
                for (String key : data.keySet()) {
                    if ( ! key.equals(KEY2) ) {
                        print(out, key, data.get(key));
                    }
                }
                out.println(); // Record separator
            }
        }
    }

    private void print(PrintStream out, String key, String data) {
        out.print("[name]");
        out.print(key);
        out.print("[/name]");
        out.print("=");
        out.print("[data]");
        out.print(data);
        out.print("[/data]");
        out.println();
    }

    private Map<String, Map<String, String>> loadFile(String fileName, String key) throws IOException {
        Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        do {
            Map<String, String> data = new HashMap<String, String>();

            while ((line = br.readLine()) != null && !line.isEmpty()) {
                data.put(getKey(line), getData(line));
            }

            result.put(data.get(key).trim(), data);
        } while (line != null);

        br.close();

        return result;
    }

    private String getKey(String line) {
        String[] tokens = line.split("=");
        int length = tokens[0].length();
        return tokens[0].substring(6, length - 7);
    }

    private String getData(String line) {
        String[] tokens = line.split("=");
        int length = tokens[1].length();
        return tokens[1].substring(6, length - 7);
    }

    public static void main(String[] args) throws IOException {
        Migrator mg = new Migrator();

        mg.migrate("post_tran.tbl", "post_tran_cust.tbl");
    }
}