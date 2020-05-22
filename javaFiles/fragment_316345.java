public class Vehicle {

  //should be private as per question
  private Integer wheelnumber;
  private Integer mpg;

  Vehicle (int wheelnum, int aMpg) {
    wheelnumber = wheelnum;
    mpg = aMpg;
  }

  public void display() {
    System.out.println("Wheels: " + wheelnumber.toString + " Mpg: " + mpg.toString);
  }

}