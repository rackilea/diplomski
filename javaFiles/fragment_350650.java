public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    System.out.println("Enter your pay rate.");
    double r = console.nextDouble();

    System.out.println("How many hours did you work this week?");
    int h = console.nextInt();

    double totalPay = getTotalPay(r, h);
    System.out.println("Total pay: " + 
        NumberFormat.getCurrencyInstance().format(totalPay)
    );
}