public void processHashMap() {
    //add keys->value pairs to a hashmap:
    HashMap hm = new HashMap();
    hm.put(1, "godric gryfindor");
    hm.put(2, "helga hufflepuff");
    hm.put(3, "rowena ravenclaw");
    hm.put(4, "salazaar slytherin");

    //Then get data back out of it:
    LinkedList ll = new LinkedList();
    Iterator itr = hm.keySet().iterator();
    while(itr.hasNext()) {
        String key = itr.next();
        ll.add(key);
    }

    System.out.print(ll);  //The key list will be printed.
}