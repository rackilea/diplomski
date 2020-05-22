public class JavaApplication33 {

  public static void main(String[] args) {

    // Create object.
    Travel crossCountry = new Travel();

    // Initial output.
    System.out.println("You decide to travel across the country.");
    System.out.println("You start your trip in Augusta, Ga.");
    System.out.println("You average 75mph and 12 hours driving per day");

    System.out.println("After " + 1 + " day ");
    crossCountry.changeDay(1);
    crossCountry.changeDistance(1);
    crossCountry.changeLocation(1);
    crossCountry.printStates();

  }
}


class Travel {

  int day = 0;
  int distance = 0;
  int location = 0;
  int increment = 900;
  String[] locations = {"Augusta", "Portland", "Kentucky", "Chicago", "NY", "Indiana"};

  void changeDay(int newValue) {
    day += newValue;

  }

  public void changeLocation(int newValue) {
    location += newValue;

  }

  public void changeDistance(int newValue) {
    distance += 75 * 12 * newValue;

  }

  void printStates() {
    System.out.println("Day: " + day + " Distance Driven: " + distance + " Current Location: "
        + locations[location]);
  }

}