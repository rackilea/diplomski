Set<String> s= new HashSet<String>();
s.addAll(hashtable.keySet());
s.retainAll(hashtable2.keySet());
System.out.println(s);
Hashtable<String, Integer> inersect = new Hashtable<String, Integer>();
for (Entry<String, Integer> entry :hashtable.entrySet()) {
    if (s.contains(entry.getKey())) {
        inersect.put(entry.getKey(), entry.getValue());
    }             
}
System.out.println(inersect);