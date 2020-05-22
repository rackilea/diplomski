private static void print(String msg, int[] list, int index) {
    System.out.println(msg);
    for(int i = 0 ; i < list.length; ++i) {
        System.out.printf("%d ", list[i]);
    }
    System.out.println();       
}