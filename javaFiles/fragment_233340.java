bool found = false;
for(Entry<String,Integer> entry : items.entrySet()) {
    found = false;
    for(int i = 0; i < unwanted.length; i++) {
        if(entry.getKey().contains(unwanted[i])) {
           found = true;            
        }
    }
    if(found == false)
      System.out.println(entry.getKey() + " = " + entry.getValue());
}