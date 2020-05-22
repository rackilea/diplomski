package stackoverflow.q30220193;

import java.util.Scanner;

public class Student {

private static String FirstName;
private static String LastName;
private static String Address;
private static String PhoneNumber;
private static int Credits;
private static double Tuition;
static double Health_Care;
static double Late_Fee;
static double Meal_Plan;
static double TotalTuition;
static double IncidentalFee;
private static boolean state;
private static boolean LateFee;
private static boolean CampusFood;
private static boolean HealthCare;
private static Scanner sc;

public static void main(String[] args) {
    sc = new Scanner(System.in);
    System.out.println("Enter first name");
    FirstName=sc.nextLine();
    System.out.println("Enter last name");
    LastName=sc.nextLine();
    System.out.println("Enter address");
    Address=sc.nextLine();
    System.out.println("Enter phone number");
    PhoneNumber=sc.nextLine();
    System.out.println("Enter the credits you are taken");
    Credits=sc.nextInt();
    System.out.println("Do you Qualify for the instate rate? Enter True for yes or False for no");
    state = sc.nextBoolean();
    System.out.println("Late fee assessed? Enter True for yes or False for no");
    LateFee=sc.nextBoolean();
    System.out.println("Do you want a meal plan? Enter True for yes or False for no");
    CampusFood=sc.nextBoolean();
    System.out.println("Do you want Health Care? Enter True for yes or False for no");
    HealthCare=sc.nextBoolean();
    calculateData();
    writeOutput();
}

public static void calculateData()
{
        if (state == true)
        {
            if (Credits < 12)
                Tuition = (Credits*102.50);
        }
    {

    if(Credits>11 || Credits<19);
        Tuition = (Credits* 75.45);
    }
    {
        if (Credits>18)
            Tuition = (Credits*93.00);
    }
    if (state == false)
    {
        if (Credits < 12)
            Tuition = (Credits*351.00);
    }
    {
    if(Credits>11 || Credits<19);
        Tuition = (Credits* 255.00);
    }
    {
    if (Credits>18)
        Tuition = (Credits*304.00);
    }
    if (LateFee == true)
    {
        Late_Fee = Tuition/10;
    } 
    if (CampusFood == true)
    {
        Meal_Plan = 3499.00;
    }
    if(HealthCare == true)
    {
        if (Credits < 11)
            Health_Care = 25.00;
        }
    { 
    if(Credits>10 || Credits<16);
        Health_Care = 20.00;
    }
    {
    if (Credits>15)
        Health_Care = 15.00;
    }
    {
        IncidentalFee = Credits * 20;
    }
    {
        TotalTuition = Tuition + Late_Fee + IncidentalFee + Health_Care + Meal_Plan;
    }
}

public static void writeOutput()
{
    System.out.println("Name: " + FirstName + " " + LastName);
    System.out.println("Address: " + Address);
    System.out.println("PhoneNumber: " + PhoneNumber);
    System.out.println("Credits: " + Credits);
    System.out.println("Tuition: " + Tuition);
    System.out.println("Late Fee: " + Late_Fee);
    System.out.println("Incedental: " + IncidentalFee);
    System.out.println("Health Care: " + Health_Care);
    System.out.println("Meal Plane: " + Meal_Plan);
    System.out.println("Total: " + TotalTuition);
}
}