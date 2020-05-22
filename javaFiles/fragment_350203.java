public class Month {
    String[] monthName = { "January", "Februry", "March",
            "April", "May", "June", "July", "August", "September",
            "October", "November", "December" }; //Months.
    int monthNumberInt = 0;
    public static String lastMonthCreated;


    /**
     A no-arg constructor that sets the monthNumber field to 1.
     */
    public Month()
    {
        monthNumberInt = 1;
    }

    /**
     A constructor that accepts the number of the month as an argument. It
     should set the monthNumber field to
     the value passed as the argument. If a value less than 1 or greater than
     12 is passed, the constructor
     should set monthNumber to 1.
     */

    public Month(int monthNumber)
    {
        if((monthNumber < 1 ) || ( monthNumber > 12)) {
        this.monthNumberInt = 1;
        } else {
            this.monthNumberInt = monthNumber;
        }

    }

    public Month(String monthName)
    {
        monthNumberInt = monthName.indexOf(monthName);
    }

    public int getMonthNumberInt() {
        return monthNumberInt;
    }

    public void setMonthNumberInt(int monthNumberInt) {
        this.monthNumberInt = monthNumberInt;
    }

    /**
     A toString method that returns the same value as the getMonthName method.
     */
    public String toString()
    {
       return  "monthName: " + monthName[monthNumberInt];
    }

    /**
     An equals method that accepts a Month object as an argument. If the
     argument object holds the same data as the
     calling object, this method should return true. Otherwise, it should
     return false.
     */

    public boolean Equals(Month m)//Month needs to go here.
    {
        if(this.monthNumberInt == m.getMonthNumberInt())
            return true;
        else
            return false;
    }

    /**
     A greaterThan method that accepts a Month object as an argument. If the
     calling object's monthNumber field
     is greater than the argument's monthNumber field, this method should
     return true. Otherwise, it should
     return false.
     */

    public boolean GreatThan(Month m1)//Month needs to go here.
    {
        if(monthNumberInt > m1.monthNumberInt)
            return true;
        else
            return false;
    }

    /**
     A lessThan method that accepts a Month object as an argument. If the
     calling object's monthNumber field is
     less than the argument's monthNumber field, this method should return
     true. Otherwise, it should return
     false.
     */

    public boolean LesserThan(Month m1)//Month needs to go here.
    {
        if(monthNumberInt < m1.monthNumberInt)
            return true;
        else
            return false;
    }
}