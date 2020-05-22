MultiMap mhm = new MultiValueMap();
String key ="";
key = "Group One";
mhm.put(key, "Item One");
mhm.put(key, "Item Two");
mhm.put(key, "Item Three");

key = "Group Two";
mhm.put(key, "Item Four");
mhm.put(key, "Item Five");


Set<String> keys = mhm.keySet();

String itemToLookFor = "Item Four";

for(String k : keys) {
    List<String> itemsWithKey = (List<String>) mhm.get(k);
    boolean doesExists = itemsWithKey.contains(itemToLookFor);
    System.out.println("does " + itemToLookFor + " exists for key " + k + ": " +doesExists); 
}