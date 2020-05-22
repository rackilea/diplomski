public class Graph {

    public static Map<String, String> bundleList = new LinkedHashMap<String, String>();

    private static Map<String, String> oldBundleList = new LinkedHashMap<String, String>();

    // ...

    private static void getAttributesFromDatabase() {
        Map<String, String> bundleInformation = new LinkedHashMap<String, String>();
        bundleInformation = getFromDatabase();
        if(!bundleInformation.isEmpty()) {
            oldBundleList = bundleList;
            bundleList = bundleInformation;
        }
    }

    // ...

    private static void loggingAfterEveryXMilliseconds() {
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {

                    }
                    getAttributesFromDatabase();
                    final Map<String, ValueDifference<String>> entriesDiffering = Maps.difference(oldBundleList, bundleList).entriesDiffering();
                    if (!entriesDiffering.isEmpty()) {
                       for (String key : entriesDiffering.keySet()) {
                           System.out.println("{" + key + "=" + bundleList.get(key) + "}");
                       } 
                    }
                    // printOutBundleInformation();
                }
            }
        }.start();
    }
}