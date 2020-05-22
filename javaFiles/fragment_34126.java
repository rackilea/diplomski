Iterator<Tuple> i = pig.openIterator("A");
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
while (i.hasNext()) {
    Integer val = DataType.toInteger(i.next().get(0));
    map.put(val, val);            
}