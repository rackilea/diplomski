int count = 0;
ArrayList<Integer> elements = new ArrayList<Integer>() {
    {
        add(4);
        add(3);
        add(1);
    }
};

ArrayList<Integer> numbers = new ArrayList<Integer>() {
    {
        add(31);
        add(21);
        add(50);
        add(70);
        add(90);
        add(80);
        add(50);
        add(100);

    }
};
for (Integer e : elements) {

    for (int i = count; i < count+e; i++) {
        System.out.print(numbers.get(i) + " ");
    }
    count += e;
    System.out.println();

}