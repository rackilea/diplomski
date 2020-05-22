public static <E> void displayArray(String label, E[] list) {
    for(E element : list) {
        if(element instanceof String)
            System.out.printf("%s", element);
        else
            System.out.printf("%s ", element);
    }
    System.out.println();
}