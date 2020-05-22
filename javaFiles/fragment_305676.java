static String test="Tick for symbol .ISEQ-IDX descriptor id 1 timestamp_sec 20130628030105 timestamp_usec 384000;EXCH_TIME 1372388465384;SENDING_TIME  0;PRICE 3957.890000;MIC XDUBIND;";

    static List<String> patterns = Arrays.asList(
        "Tick for symbol", "\\S+",
        "descriptor id", "\\d+",
        "timestamp_sec", "\\d+",
        "timestamp_usec", "\\d+",
        "EXCH_TIME", "\\d+",
        "SENDING_TIME","\\d+",
        "PRICE", "\\d+.\\d",
        "MIC", "\\S+"
      );


        public static void main(String[] args) {
            Map<String,String> map = new HashMap<>();

            for (int i = 0; i<patterns.size();i+=2) {
                String key = patterns.get(i);
                String val = patterns.get(i+1);
                String pattern = "\\Q" +key + "\\E\\s+(" + val + ")";
                Matcher m = Pattern.compile(pattern).matcher(test);

                if (m.find()) {
                    map.put(key, m.group(1));
                }
            }
            System.out.println(map);

        }