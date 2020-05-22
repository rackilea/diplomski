HashMap<Class, Integer> hm1 = new HashMap<>();
HashMap<Class, Integer> hm2 = new HashMap<>();
for (Class c : list1) {
    if (!hm1.containsKey(c)) {
        hm1.put(c, 1);
    } else {
        hm1.put(c, hm1.get(c)+1);
    }
}
for (Class c : list2) {
    if (!hm2.containsKey(c)) {
        hm2.put(c, 1);
    } else {
        hm2.put(c, hm2.get(c)+1);
    }
}
if (hm1.equals(hm2) {
    //lists are the same in your understanding of the same
}