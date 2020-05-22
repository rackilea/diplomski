public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");//789
    String number = input.nextLine();
    System.out.print(number.replace("", "\n"));
}