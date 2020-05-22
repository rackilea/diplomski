public static void main(String[] args) throws InterruptedException {
    ArrayList<Integer> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int nElements = scanner.nextInt();
    for (int i = 0; i < nElements; i++) {
        list.add(scanner.nextInt());
    }
    ArrayList<Integer> newList = new ArrayList<>();
    TreeSet<Integer> set = new TreeSet<>();
    for (Integer aList : list) {
        Integer tmp = set.ceiling(aList + 1);
        if (tmp == null) {
            newList.add(-1);
        } else {
            newList.add(tmp);
        }
        set.add(aList);
    }
    list = newList;
}