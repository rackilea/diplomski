final static String skus[] = {
    "AKD123",
    "AKD123",
    "REN134",
    "PIK383",
    "REN134",
    "REN134",
    "PIK383",
    "REN134"
};

final static String timestamp[] = {
    "2012-02-01",
    "2012-04-14",
    "2012-02-01",
    "2012-10-07",
    "2012-02-01",
    "2012-02-01",
    "2012-03-01",
    "2012-02-01"
};


@Test
public void countSkusPerDay() {
    Map<String, Map<String, Integer>> countMap = new HashMap<>();
    for(int i = 0; i < skus.length; i++) {
        String sku = skus[i];
        String date = timestamp[i];
        Map<String, Integer> countPerDateMap = countMap.get(sku);
        if(countPerDateMap == null) {
            countPerDateMap = new HashMap<>();
            countMap.put(sku, countPerDateMap);
        }
        Integer count = countPerDateMap.get(date);
        if(count == null) {
            countPerDateMap.put(date, 1);
        } else {
            countPerDateMap.put(date, count.intValue() + 1);
        }
    }

    for(Map.Entry<String, Map<String, Integer>> e : countMap.entrySet()) {
        System.out.println("sku " + e.getKey() + " sold in " + e.getValue().size() + " day(s) " + e.getValue());
    }
}