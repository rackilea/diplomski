StringBuilder csv = new StringBuilder();
int row = 0;
ArrayList<ArrayList> list = new ArrayList<ArrayList>();

// Write the keys row:
Iterator keys = hashmap.keySet().iterator();
boolean notFirst = true;
while(keys.hasNext()) {
    String key = (String)keys.next();
    ArrayList tmp = (ArrayList)hashmap.get(key);
    if(!notFirst) {
        csv.append(",");
    }
    csv.append(key);
    // store list
    list.add(tmp);
    notFirst = false;
}
csv.append("\n");


// Write the rest of the rows
while(row<numberOfTotalRow) {
    notFirst = true;
    for(int x=0;x<list.size();x++) {
        if(!notFirst) {
            csv.append(",");
        }
        csv.append((String)list.get(x).get(row));
        notFirst = false;
    }   
    row++; 
}