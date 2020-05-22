public static void main(String[] args) {

    ArrayList<String> date = new ArrayList<>();
    date.add("1");
    date.add("2");
    date.add("2");
    date.add("3");
    System.out.println(date);

    ArrayList<Integer> value = new ArrayList<>();
    value.add(1);
    value.add(2);
    value.add(4);
    value.add(3);
    System.out.println(value);

    new MyCls().createList(date, value);

}