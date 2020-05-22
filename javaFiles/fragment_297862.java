public static void main(String[] args) {
    Main main = new Main();
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < 100; i++) {
        list.add(main.prizegenerator());
    }
    Collections.sort(list);

    for (Integer integer : list) {
        System.out.println(integer);
    }
}