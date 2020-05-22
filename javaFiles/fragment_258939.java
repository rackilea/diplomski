public long fibb()
{
    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(1);
    list.add(1);

    while (list.get(0) + list.get(1) < 4000000) {
        // Use list.add(0, ...) to add entries to the *front*.
        list.add(0, list.get(0) + list.get(1));
    }     

    long value = 0;

    for (int i = 0; i < list.size(); i++) {
        if (list.get(i) % 2 == 0) {
            value += list.get(i);
        }    
    }

    return value;
}