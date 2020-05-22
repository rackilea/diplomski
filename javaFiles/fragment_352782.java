public class Test {

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.execute();
    }

    private static String TYPE_XTSM = "XTSM";
    private static String TYPE_XTS = "XTS";
    private static String TYPE_XRX = "XRX";
    private static String TYPE_XHAN = "XHAN";

    private void execute() throws IOException {
        InputStream in = null;
        BufferedReader br = null;
        TreeMap<Integer, TreeMap<Integer, Integer>> xtsmMap = new TreeMap<Integer, TreeMap<Integer, Integer>>();
        try {
            in = Test.class.getResourceAsStream("test1.txt");
            br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                Record rec = new Record(line);
                processRecord(xtsmMap, rec);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        printResults(xtsmMap);
    }

    private void processRecord(
            TreeMap<Integer, TreeMap<Integer, Integer>> xtsmMap, Record rec) {
        TreeMap<Integer, Integer> xtsMap;
        if (xtsmMap.containsKey(rec.getXtsm())) {
            xtsMap = xtsmMap.get(rec.getXtsm());
        } else {
            xtsMap = new TreeMap<Integer, Integer>();
            xtsmMap.put(Integer.valueOf(rec.getXtsm()), xtsMap);
        }
        if (xtsMap.containsKey(rec.getXts())) {
            Integer count = xtsMap.get(rec.getXts());
            xtsMap.put(Integer.valueOf(rec.getXts()), Integer.valueOf(count
                    .intValue() + 1));
        } else {
            xtsMap.put(Integer.valueOf(rec.getXts()), Integer.valueOf(1));
        }
    }

    private void printResults(
            TreeMap<Integer, TreeMap<Integer, Integer>> xtsmMap) {
        System.out.println("Type\t\tTotal");
        Set<Integer> xtsmSet = xtsmMap.navigableKeySet();
        for (Integer xtsm : xtsmSet) {
            TreeMap<Integer, Integer> xtsMap = xtsmMap.get(xtsm);
            Set<Integer> xtsSet = xtsMap.navigableKeySet();
            for (Integer xts : xtsSet) {
                Integer count = xtsMap.get(xts);
                String outputLine = TYPE_XTSM + ":" + xtsm + "/" + TYPE_XTS
                        + ":" + xts + "\t" + count;
                System.out.println(outputLine);
            }
        }
    }

    private static class Record {

        private Integer xtsm, xts, xrk, xhan;

        Record(String line) {
            StringTokenizer st = new StringTokenizer(line, "/");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                String type = token.substring(0, token.indexOf(":"));
                String valueStr = token.substring(token.indexOf(":") + 1, token
                        .length());
                Integer value = Integer.valueOf(valueStr);
                if (TYPE_XTSM.equals(type)) {
                    xtsm = value;
                } else if (TYPE_XTS.equals(type)) {
                    xts = value;
                } else if (TYPE_XRX.equals(type)) {
                    xrk = value;
                } else if (TYPE_XHAN.equals(type)) {
                    xhan = value;
                }
            }
        }

        public Integer getXtsm() {
            return xtsm;
        }

        public Integer getXts() {
            return xts;
        }

        public Integer getXrk() {
            return xrk;
        }

        public Integer getXhan() {
            return xhan;
        }
    }
}