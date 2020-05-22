public static <T> void printList(List<T> list) {
    for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i).toString());
        if (i != list.size() - 1)
            System.out.print(", ");
    }
    System.out.println();
}