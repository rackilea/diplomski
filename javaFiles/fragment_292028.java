final Map<String, String> hm1 = new HashMap<String, String>();
hm1.put("BOF", "SAPF");
hm1.put("BOM", "SAPM");
hm1.put("BOL", "SAPL");

final Map<String, String> hm2 = new HashMap<String, String>();
hm2.put("BOF", "Data1");
hm2.put("BOL", "Data2");

final Map<String, String> hm3 = new HashMap<String, String>();

for (final String key : hm1.keySet()) {
    if (hm2.containsKey(key)) {
        hm3.put(hm1.get(key), hm2.get(key));
    }
}