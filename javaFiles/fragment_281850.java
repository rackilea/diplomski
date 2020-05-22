public static void main(String args[]){
    Scanner one = new Scanner(System.in);
    System.out.print("Enter Id");
    String number =one.nextLine();
    int e = Integer.parseInt(number);
    System.out.print("Enter Your Name");
    String f = one.nextLine();
    Student1 s = new Student1();
    s.get(e ,f);
    s.show();
}