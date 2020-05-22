public static void main(String[] args) {
    B b = new B();

    System.out.println("Before any insert :" +b);

    b.insert(1);
    b.insert(4);

    System.out.println("After first insert :" +b);

    b.insert(18);
    b.insert(23);

    System.out.println("After second insert :" +b);

    b.insert(25);
    b.insert(25);

    System.out.println("After third insert :" +b);

    b.insert(28);
    b.insert(57);

    System.out.println("After fourth insert :" +b);
}