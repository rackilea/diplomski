import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sky {

  private static Map<String, Integer> planetMap = new HashMap<String,Integer>();
  public static void main(String args[]) {
    populateDB();
    Scanner scanner = new Scanner(System.in);

    String planetName = scanner.nextLine();

    if(planetMap.get(planetName) != null) {
      System.out.println("The planet "+ planetName +" was found in "+ planetMap.get(planetName));
    }
    else {
      System.out.println("Invalid Planet Name");
    }

  }

  public static void populateDB() {


    planetMap.put("Earth", 1600);
    planetMap.put("Mars", 1500);
    planetMap.put("Jupiter", 1100);
    planetMap.put("Saturn", 1900);
    planetMap.put("Venus", 1300);
  }
}