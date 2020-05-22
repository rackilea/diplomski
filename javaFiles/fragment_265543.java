import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sky{
    private static Map<String, Planet> planetMap = new HashMap<String, Planet>();

    public static void main(String args[]) {
        populateDB();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input planet name: ");
        String planetName = scanner.nextLine();

        //converting to lowercase so user input Earth and earth and EARTH eArTH all match
        if (planetMap.containsKey(planetName.toLowerCase())) {
            //invokes the overrided toString() of Planet class
            System.out.println(planetMap.get(planetName.toLowerCase()).toString());
        } else {
            System.out.println("Invalid Planet Name");
        }
    }

    public static void populateDB() {
        Planet earth = new Planet("Earth", "4x", 1600); 
        Planet mars = new Planet("Mars", "1x", 1500); 
        Planet jupiter = new Planet("Jupiter", "3x", 1100); 
        Planet saturn = new Planet("Saturn", "16x", 1900); 
        Planet venus = new Planet("Venus", "5x", 1300); 

        planetMap.put("earth", earth); 
        planetMap.put("mars", mars); 
        planetMap.put("jupiter", jupiter); 
        planetMap.put("saturn", saturn); 
        planetMap.put("venus", venus); 
    }
}

class Planet {
    String name;
    String gravityStrength;
    int found;

    //empty constructor
    public Planet() {}

    public Planet(String name, String gravityStrength, int found) {
        this.name = name; 
        this.gravityStrength = gravityStrength; 
        this.found = found; 
    }

    /* Getters and setters */ 

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGravityStrength() {
        return gravityStrength;
    }
    public void setGravityStrength(String gravityStrength) {
        this.gravityStrength = gravityStrength;
    }

    public int getFound() {
        return found;
    }
    public void setUniverse(int found) {
        this.found = found;
    }

    //override toString methdo to pretty-print planet
    public String toString() {
        return "Planet " + name + " with gravity strenght " + gravityStrength + " was found in " + found; 
    }
}