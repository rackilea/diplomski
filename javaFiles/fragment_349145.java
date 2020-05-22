public static void processFile(){ 
    //...

    Collections.sort(incom, new IncomComparator());
    //...
}


class IncomComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        /* compare logic goes here
           return a negative number when o1 < o2
                  a positive number when o1 > o2
                  0 when o1 == o2
        */ 
        return 0;
    }

}