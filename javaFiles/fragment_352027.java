class Main {
  public static void main(String[] args) {
    UberUser user = new UberUser("Tom, Wing Stop, Franklin Mountain,  28, 5, 39.16");
    System.out.println(user);
  }
}

class UberUser{
  String name;
  String pickUp;
  String destination;
  int rideTime;
  int miles;
  double earning;

  public UberUser(String s){
    String line = s;
    s=s.replaceAll("\\s","");

    String tokens[] = s.split(",");   
    this.name = tokens[0];
    this.pickUp = tokens[1];
    this.destination = tokens[2];
    this.rideTime = Integer.parseInt (tokens[3]);
    this.miles = Integer.parseInt (tokens[4]);
    this. earning = Double.parseDouble(tokens[5]);
  }

  public String toString() { 
    return String.format("Name: %s\nPick-Up: %s\nDestination: %s\nRide Time: %d\nMiles: %d\nEarning: £%f", name, pickUp, destination, rideTime, miles, earning);
  }
}