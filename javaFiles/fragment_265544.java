import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sky {
    private static Map<String, HashMap<String, String>> planetMap = new HashMap<String, HashMap<String, String>>();

    public static void main(String args[]) {
        populateDB();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter planet name to search for: ");
        String planetName = scanner.nextLine();

        if (planetMap.containsKey(planetName.toLowerCase())) {
            HashMap<String, String> p = planetMap.get(planetName.toLowerCase());
            System.out.println("The planet " + planetName + " was found in " + p.get("name")
                    + " and has gravity strenght of " + p.get("gravityStrength"));
        } else {
            System.out.println("Invalid Planet Name");
        }

    }

    public static void populateDB() {
        HashMap<String, String> earthDetails = new HashMap<String, String>();
        earthDetails.put("name", "Earth");
        earthDetails.put("gravityStrength", "4X");
        earthDetails.put("found", "1600");

        HashMap<String, String> marsDetails = new HashMap<String, String>();
        marsDetails.put("name", "Mars");
        marsDetails.put("gravityStrength", "31X");
        marsDetails.put("found", "1500");

        HashMap<String, String> jupiterDetails = new HashMap<String, String>();
        jupiterDetails.put("name", "Jupiter");
        jupiterDetails.put("gravityStrength", "1X");
        jupiterDetails.put("found", "1100");

        HashMap<String, String> saturnDetails = new HashMap<String, String>();
        saturnDetails.put("name", "Saturn");
        saturnDetails.put("gravityStrength", "100X");
        saturnDetails.put("found", "1900");

        HashMap<String, String> venusDetails = new HashMap<String, String>();
        venusDetails.put("name", "Venus");
        venusDetails.put("gravityStrength", "150X");
        venusDetails.put("found", "1300");

        planetMap.put("earth", earthDetails);
        planetMap.put("mars", marsDetails);
        planetMap.put("jupiter", jupiterDetails);
        planetMap.put("saturn", saturnDetails);
        planetMap.put("venus", venusDetails);
    }
}