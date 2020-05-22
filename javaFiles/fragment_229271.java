Set<Entry<Integer,String>> set = hmap.entrySet();
Iterator<Entry<Integer,String>> it = set.iterator();
while(it.hasNext()){
    Entry<Integer, String> me = it.next();
    System.out.println("key is:"+me.getKey()+" & value is: "+me.getValue());
}