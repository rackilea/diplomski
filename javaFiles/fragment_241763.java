public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0); 
    list.add(1);
    list.add(23);
    list.add(50);
    list.add(3);
    list.add(20);
    list.add(17);

    list.sort(new CustomComparator());
}