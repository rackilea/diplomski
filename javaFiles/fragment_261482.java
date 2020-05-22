public class PizzaStore {

static String[] records = new String[]{"100|Pete's Pizza Palace|George Smith|200",
    "400|Pete's Pizza Palace|George Smith|30",
    "320|Pete's Pizza Palace|George Smith|-13",
    "310|Pete's Pizza Palace|John Smith|2"};

public static void main(String[] args) {
    fileRecords(records);
}

static void fileRecords(String[] records) {

    int len = records.length;

    HashMap<String, Integer> runningTotals = new HashMap<>();

    for (int i = 0; i < len; i++) {
        String rec = records[i];
        String[] fields = rec.split("\\|");
        String storeName = fields[1] + "|" + fields[2];
        Integer value = new Integer(fields[3]);
        if (!runningTotals.containsKey(storeName)) {
            runningTotals.put(storeName, 0);            
        }
        runningTotals.put(storeName, runningTotals.get(storeName) + value);
    }

    for (String s : runningTotals.keySet()) {
        System.out.println(s + "|" + runningTotals.get(s));
    }

}
}