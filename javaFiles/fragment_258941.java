public long fibb()
{
    List<Integer> list = new LinkedList<Integer>();
    long value = 0;

    list.add(1);
    list.add(1);

    while (list.get(0) + list.get(1) < 4000000) {
        int next = list.get(0) + list.get(1);

        list.add(0, next);

        if (next % 2 == 0) {
            value += next;
        }    
    }     

    return value;
}