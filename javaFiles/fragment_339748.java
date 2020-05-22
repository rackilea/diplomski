Iterator<Entry<List<Integer>, Integer>> i1 = hm.entrySet().iterator() ; 
while(i1.hasNext()) {
    Entry<List<Integer>, Integer> pair1 = i1.next() ; 
    Iterator<Entry<List<Integer>, Integer>> i2 = hm.entrySet().iterator() ;
    while(i2.hasNext()) {
        Entry<List<Integer>, Integer> pair2 = i2.next() ; 
        // Do some joining part here

        System.out.println(pair1.getKey());
        System.out.println(pair2.getKey());
        } 
    }
}