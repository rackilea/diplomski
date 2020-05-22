public class SalesRepresentativeAPP {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String ID;
        String name;
        int yearServiced;
        double salesVolume;

        System.out.println("Please enter your Year of Service : ");
        yearServiced = sc.nextInt();
        System.out.println("Please enter your sales volume : ");
        salesVolume = sc.nextDouble();

        SalesRepresentative s1 = new SalesRepresentative("id", "name", yearServiced, salesVolume);

        System.out.println("Your total salary is : " + s1.getCommision() + "\nBasic Salary is : " + s1.getSalary());

    }

}