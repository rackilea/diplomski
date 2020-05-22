void add (int x, int y) {
    if (x<4) {
        int sum = x + y;
        System.out.println(sum);
        add(sum,x);
    } else {
      printMessage();
    }
}