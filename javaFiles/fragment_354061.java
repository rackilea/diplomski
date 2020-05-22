public static void main(String[] args) {
    String eoro;
    String name = "10";
    int num = Integer.parseInt(name, 2);
    System.out.println(num);
    if(num % 2 == 0)
        eoro = "even";
    else
        eoro = "odd";
    System.out.println(eoro);
}