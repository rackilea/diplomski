public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your total coins:");
    System.out.print("Quarters:");
    System.out.flush();
    int quarters = input.nextInt();
    System.out.print("Dimes:");
    System.out.flush();
    int dimes = input.nextInt();
    System.out.print("Nickles:");
    System.out.flush();
    int nickels = input.nextInt();
    System.out.print("Pennies:");
    System.out.flush();
    int pennies = input.nextInt();
    DecimalFormat fmt = new DecimalFormat("$#,###.##");
    System.out.println(fmt.format(calctotal(quarters, dimes, nickels,
            pennies)));
}