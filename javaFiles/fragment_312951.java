Iterator iterator = hm.entrySet().iterator();
Object prev = null;

while (iterator.hasNext()) {
    Object next = iterator.next();
    // Do your stuff
    prev = next;
}