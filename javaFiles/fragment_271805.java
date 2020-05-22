import java.text.DecimalFormat;

public class Employee
{  // begin class

// *********** CLASS VARIABLES **********

// *********** CLASS CONSTANTS **********

    private static int MAXHOURS = 40;   // maximum hours before overime
    private static double OTRATE = 1.5; // overtime is one and a half

// ********** INSTANCE VARIABLES **********

    private int ID;                     // employee's id
    private int Hours;                  // number of hours worked
    private double Wage;                // pay per hour

    private double RegularPay;          // regular pay
    private int  OverHours;         // number of overtime hours worked
    private double OverPay;             // overtime pay
    private double GrossPay;                // gross pay

// ********** CREATE INPUT STREAMS **********

    DecimalFormat df1 = new DecimalFormat ("#####.00");     // to get two decimal places at the end of the numbers

// ********** CONSTRUCTORS ***********

    public Employee(int IDnumber)
    { // begin initialized constructor
        ID = IDnumber;          // set ID to ID number
    } // end initialized constructor

// ********** ACCESSORS **********

    public int getID()
    { // begin getID
        return ID;
    } // end getID

    public void setWage(double HourlyWage)
    { // begin setWage
        Wage = HourlyWage;
    } // end setWage

    public double getWage()
    { // begin getWage
        return Wage;
    } // end getWage

    public void setHours(int hoursWorked)
    { // begin setHours
        Hours = hoursWorked;
    } // end setHours

    public double getHours()
    { // begin getHours
        return Hours;
    } // end getHours

// ********** MUTATORS **********

    public double getOverPay()
    { // begin getOverPay
        if (Hours > MAXHOURS)
{ // begin if hours worked is bigger than MAXHOURS
            OverHours = Hours - MAXHOURS;
            OverPay = OverHours * Wage * OTRATE;
        } // end if hours worked is bigger than MAXHOURS
        else
            OverPay = 0;

        return OverPay;
    } // end getOverPay

    public double getRegularPay()
    { // begin getRegularPay

        return MAXHOURS * Wage;
    } // end getRegularPay

    public double getGrossPay()
    { // begin getGrossPay
        return getRegularPay() + OverPay;
    } // end getGrossPay


    public String toString()    // overrides the toString method inherited from object
    { // begin toString
        String strout = "\nId \t\t Hours \t\t Rate \t\t Regular Pay \t Overtime Pay \t Gross Pay\n";
        strout += ID + "\t " + Hours + "\t\t\t $" + (df1.format(Wage)) + "\t\t $" + (df1.format(getRegularPay())) + "\t\t\t $" + (df1.format(getOverPay())) + "\t\t\t $" + (df1.format(getGrossPay()));    
            // df1.format(double) allows me two decimal places  

        return strout;
    } // end toString

}  // end class