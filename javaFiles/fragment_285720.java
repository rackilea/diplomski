public static void main(String[] args) {

    int[] array = {1, 2, 2, 3, 3, 4, 5, 5, 3, 4, 3, 4, 6, 6, 1, 3, 3, 3};
    Arrays.sort(array);
    List<Integer> list = new ArrayList<>();
    for (int x : array) {
        list.add(x);
    }
    for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i) + " ");
    }
    System.out.println();
    System.out.println("\nDuplicate element(s)");
    Integer last = null;
    Iterator<Integer> it = list.iterator();
    while (it.hasNext()){
        Integer n = it.next();
        if (n.equals(last)){
            System.out.print(n + " ");
            it.remove();
        }
        last = n;
    }
    System.out.println();

    System.out.println("\nDuplicate element(s) removed");

    for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i) + " ");
    }
    System.out.println();
}