import java.util.Scanner;

public class Student {

public static void main(String[] args) {
    //add the code for what you want to do in here
}

private String FirstName;
private String LastName;
private String Address;
private String PhoneNumber;
private int Credits;
private double Tuition;
double Health_Care;
double Late_Fee;
double Meal_Plan;
double TotalTuition;
double IncidentalFee;
private boolean state;
private boolean LateFee;
private boolean CampusFood;
private boolean HealthCare;

public Student(){
}

public Student(String studentFirstName, String studentLastName, String studentAddress,String studentPhoneNumber, int studentCredits, double studentTuition, double studentHealth_Care, double studentLate_Fee, double studentMeal_Plan, double studentTotalTuition, double studentIncidentalFee, boolean studentstate, boolean studentLateFee, boolean studentCampusFood, boolean studentHealthCare){
    FirstName = studentFirstName;
    LastName = studentLastName;
    Address = studentAddress;
    PhoneNumber = studentPhoneNumber;
    Credits = studentCredits;
    Tuition = studentTuition;
    Health_Care = studentHealth_Care;
    Late_Fee = studentLate_Fee;
    Meal_Plan = studentMeal_Plan;
    TotalTuition = studentTotalTuition;
    IncidentalFee = studentIncidentalFee;
    state = studentstate;
    LateFee = studentLateFee;
    CampusFood = studentCampusFood;
    CampusFood = studentHealthCare;
}

// Set Methods
void FirstName (String studentFirstName){
    FirstName = studentFirstName;
}

void LastName (String studentLastName){
    LastName = studentLastName;
}

void Address (String studentAddress){
    Address = studentAddress;
}

void PhoneNumber (String studentPhoneNumber){
    PhoneNumber = studentPhoneNumber;
}

void Credits (int studentCredits){
    Credits = studentCredits;
}

void Tuition (double studentTuition){
    Tuition = studentTuition;
}

void Health_Care (double studentHealth_Care){
    Health_Care = studentHealth_Care;
}

void Late_Fee (double studentLate_Fee){
    Late_Fee = studentLate_Fee;
}

void Meal_Plan (double studentMeal_Plan){
    Meal_Plan = studentMeal_Plan;
}

void TotalTuition (double studentTotalTuition){
    TotalTuition = studentTotalTuition;
}

void IncidentalFee (double studentIncidentalFee){
    IncidentalFee = studentIncidentalFee;
}

void state (Boolean studentstate){
    state = studentstate;
}

void LateFee (Boolean studentLateFee){
    LateFee = studentLateFee;
}

void CampusFood (Boolean studentCampusFood){
    CampusFood = studentCampusFood;
}

void HealthCare (Boolean studentHealthCare){
    HealthCare = studentHealthCare;
}

// Get Method
String FirstName(){
    return FirstName;
}

String LastName(){
    return LastName;
}

String Address(){
    return Address;
}

String PhoneNumber(){
    return PhoneNumber;
}

int Credits(){
    return Credits;
}

double Tuition(){
    return Tuition;
}

double Health_Care(){
    return Health_Care;
}

double Late_Fee(){
    return Late_Fee;
}

double Meal_Plan(){
    return Meal_Plan;
}

double TotalTuition(){
    return TotalTuition;
}

double IncidentalFee(){
    return IncidentalFee;
}

boolean state(){
    return state;
}

boolean LateFee(){
    return LateFee;
}

boolean CampusFood(){
    return CampusFood;
}

boolean HealthCare(){
    return HealthCare;
}

public void readInput(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter first name");
    FirstName=sc.next();
    System.out.println("Enter last name");
    LastName=sc.next();
    System.out.println("Enter address");
    Address=sc.next();
    System.out.println("Enter phone number");
    PhoneNumber=sc.next();
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
}

public void calculateData(){
    if (state == true){
        if (Credits < 12){
            Tuition = (Credits*102.50);
        }
    }
    if(Credits>11 || Credits<19){
        Tuition = (Credits* 75.45);
    }
    if (Credits>18){
        Tuition = (Credits*93.00);
    }
    if (state == false){
        if (Credits < 12){
            Tuition = (Credits*351.00);
        }
    }
    if(Credits>11 || Credits<19){
        Tuition = (Credits * 255.00);
    }
    if (Credits>18){
        Tuition = (Credits * 304.00);
    }
    if (LateFee == true){
        Late_Fee = Tuition / 10;
    }
    if (CampusFood == true){
        Meal_Plan = 3499.00;
    }
    if(HealthCare == true){
        if (Credits < 11){
            Health_Care = 25.00;
        }
    }
    if(Credits>10 || Credits<16){
        Health_Care = 20.00;
    }
    if (Credits>15){
        Health_Care = 15.00;
    }
    IncidentalFee = Credits * 20;
    TotalTuition = Tuition + Late_Fee + IncidentalFee + Health_Care + Meal_Plan;
}

public void writeOutput(){
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