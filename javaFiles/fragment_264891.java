int a = 0;
    int b = 0;
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter two numbers");
    a = input.nextInt();
    b = input.nextInt();
    JOption jp = new JOption();
    jp.makes10(a, b);
}

public boolean makes10(int a, int b) {
    return ((a + b) == 10 || a == 10 || b == 10);

}