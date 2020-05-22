Iterator<Integer> itr = num.iterator();
while(itr.hasNext()) {
    Integer val = (Integer) itr.next();
    if(val.equals(in)) {
        itr.remove();
    }
}