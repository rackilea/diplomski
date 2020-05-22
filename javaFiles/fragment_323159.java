StringBuilder keyRow = new StringBuilder();
StringBuilder value1 = new StringBuilder();
StringBuilder value2 = new StringBuilder();
StringBuilder value3 = new StringBuilder();

Iterator keys = hashmap.keySet().iterator();
boolean notFirst = true;
while(keys.hasNext()) {
    String key = (String)keys.next();
    ArrayList list = (ArrayList)hashmap.get(key);
    if(!notFirst) {
        keyRow.append(",");
        value1.append(",");
        value2.append(",");
        value3.append(",");
    }
    keyRow.append(key);
    value1.append((String)list.get(0));
    value2.append((String)list.get(1));
    value3.append((String)list.get(2));
    notFirst = false;
}