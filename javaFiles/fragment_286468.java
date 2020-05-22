public static void function(int n)// suppose that n = 6 and arrayB have these value {1,2,3,1,1,1,1,2}
{
    int count = 0;

    LinkedList<Integer> subList = new LinkedList<>();
    for (int w : arrayB) {
        count = w + count;
        subList.add(w);
        if (count == n) {
            count = 0;
            p.add((LinkedList) subList); // p is adding a new list reference every time
            subList = new LinkedList<>(); // create a new list object, subList points to a new list object
        }
    }
}