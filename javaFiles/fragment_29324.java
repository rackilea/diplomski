import java.util.Scanner;

public class calculatetax {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int employeehr = 0;
        int ratehr = 0;
        String stateresidence = "";
        String maritalstatus = "";

        System.out.println(" Employee Hours pls ");
        employeehr = kb.nextInt();

        System.out.println(" Hourly Rate ");
        ratehr = kb.nextInt();

        System.out.println(" State of residence");
        stateresidence = kb.nextLine();

        System.out.println("Marital Status");
        maritalstatus = kb.nextLine();

        int wages = calculatewages(employeehr, ratehr);
        double fedtax = calculatefedtax(wages, maritalstatus);
        System.out.println("Fedtax:" + fedtax);
    }

    public static int calculatewages(int n1, int n2) {

        int wages = n1 * n2;
        System.out.println("Return Wages" + wages);
        return wages;
    }

    public static double calculatefedtax(double fedtax, String maritalstatus) {

        if (maritalstatus.equals("marry")) {
            fedtax = fedtax * .20;
        } else if (maritalstatus.equals("single")) {
            fedtax = fedtax * .25;
        } else {
            fedtax = fedtax * .22;
        }
        return fedtax;

    }

}