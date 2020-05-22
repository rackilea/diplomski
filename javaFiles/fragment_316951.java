void iteratorMethod(){
    Iterator it = top.entrySet().iterator();

    for (int i = 0; (i < 5) && it.hasNext(); i++) {
        Multiset.Entry entry = (Multiset.Entry) it.next();

        String word = (String) entry.getElement();
        int count = entry.getCount();

        System.out.println(word + " -> " + count);
    }
}