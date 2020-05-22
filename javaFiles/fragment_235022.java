public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(7);
    list.add(0);
    list.add(2);
    list.add(9);
    list.add(0);
    list.add(1);
    list.add(0);
    list.add(4);

    Set<Integer> indexesOf = new HashSet<>();
    int indexOf = -1;
    int shift = 0;
    while ((indexOf = list.indexOf(Integer.valueOf(0))) != -1) {
        indexesOf.add(indexOf + shift++);
        list.remove(indexOf);
    }

    Collections.sort(list);
    indexesOf.stream().forEach(index -> list.add(index, Integer.valueOf(0)));
    System.out.println(list);
}