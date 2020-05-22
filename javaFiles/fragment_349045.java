public static ArrayList<Integer> doSomething(int n) {
    if (n <= 0) {
        return new ArrayList<Integer>();
    }
    ArrayList<Integer> list = doSomething(n - 1);
    list.add(n);
    return list;
}