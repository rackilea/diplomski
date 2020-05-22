public long fibb()
{
    // Changed to use a linked list for faster insertions.
    List<Integer> list = new LinkedList<Integer>();

    list.add(1);
    list.add(1);

    // Using get() is normally a bad idea on linked lists, but we can get away
    // with get(0) and get(1) since those indexes are small.
    while (list.get(0) + list.get(1) < 4000000) {
        list.add(0, list.get(0) + list.get(1));
    }     

    long value = 0;

    // Altered loop to avoid expensive get(i) calls.
    for (Integer n: list) {
        if (n % 2 == 0) {
            value += n;
        }    
    }

    return value;
}