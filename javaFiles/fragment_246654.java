// A Vaction is 10 days
// but an ExtendedVacation is 30 days
public class testclass1
{
    public static void main(String args[])
    {
          // Declaration must be done here.
          int days = 10; // Or any other value.


          // Then you simply pass the value of the variable as a parameter here.
          DebugVacation myVacation = new DebugVacation(days);

          DebugExtendedVacation yourVacation = new DebugExtendedVacation(days);

          System.out.println("My vacation is for " +
             myVacation.getDays() + " days");

          System.out.println("Your vacation is for " +
             yourVacation.getDays() + " days");
    }
}

//_____________________________________


class DebugExtendedVacation extends DebugVacation
{
  public DebugExtendedVacation(int days)
  {
      super(days);
          days = 30;
  }

  public int getDays()
  {
        super.getDays();
        return days;

  }
}

//______________________

class DebugVacation
{
  public int days = 10;

  public DebugVacation(int days)
  {
     this.days = days;
  }
  public int getDays()
  {
          return days;
  }
}