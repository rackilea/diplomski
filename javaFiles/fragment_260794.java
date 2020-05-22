public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Capital");
    double startcapital = sc.nextDouble();

    System.out.println("Enter Interest Rate");
    double interest_rate = sc.nextDouble();

    System.out.println("Enter Year");
    int duration = sc.nextInt();

    sc.close();

    double end = endkapitalDoWhile(startcapital, interest_rate, duration);
    System.out.println("DoWhile-Schleife: " + end);

}
public static double endkapitalDoWhile(double startcapital, double interest_rate, int duration) {
int counter = 1;
    do {
        if (counter % 3 == 0) {
            interest_rate = interest_rate + 0.1;
        } else{
            interest_rate = interest_rate;
        }
        startcapital = startcapital + (startcapital *(interest_rate/100));
        counter++;            
    } while (counter <= duration);      

    return startcapital;
}