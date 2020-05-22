Set<String> set = pmMap.keySet();
for(String key : set) {
ArrayList<String> list = null;
if(value1.equals(key)) {
list = pmMap.get(key);
list.add(value2);
pmMap.put(key, list);
}