ArrayList<Contact>a = new ArrayList<>(500);
 Queue<Contact>b = new LinkedList<>();
 // maintain queue size of size 10
 int aIndex  = 0;
 for (int i = 0; i < 10; ++i) {
     b.add(a.get(aIndex++));
 }
 while (true) {
    if (b.isEmpty()) break; // break when all call are completed
    Contact frontValue = b.poll(); // get queue's first element and remove it
    // assign above contact to channel
    // put another contact from a to b
    if (aIndex  < a.size()) {
        b.add(a.get(aIndex++));
    }
 }