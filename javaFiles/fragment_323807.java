public static void main(String args[]) {
    //example numbers
    final Random r = new Random();
    final List<ExampleObject> arrList = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
        ExampleObject obj = new ExampleObject();
        obj.position = r.nextInt(1000);
        arrList.add(obj);
    }

    //comparator (as a lambda)
    Collections.sort(arrList, (a, b) -> {
        return a.position - b.position;
    });

    //output result
    for (ExampleObject obj : arrList) {
        System.out.println(obj.position);
    }
}