import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Element {
    public static void main(String[] args) throws IOException {
        Scanner kbd = new Scanner(System.in);
        Map<String, Map<String, Double>> elementsMap = new HashMap<>();
        File file = new File("elements.txt");
        Scanner read = new Scanner(file);
        while (read.hasNext()) {
            elementsMap.putIfAbsent(read.next(), Collections.singletonMap(read.next(), Double.valueOf(read.next())));
        }


        System.out.println("Enter a chemical compound: ");
        String compound = kbd.nextLine();
        compound = compound + " ";
        System.out.println("Chemical compound of " + compound);

        double compoundWeight = 0.0;
        for (int x = 0; x < compound.length(); x++) {

            String elementKey = String.valueOf(compound.charAt(x));
            if (elementsMap.containsKey(elementKey)) {
                Map<String, Double> element = elementsMap.get(elementKey);
                int noOfElements = 0;

                while (String.valueOf(compound.charAt(x + 1)).matches("([1-9])")) {
                    noOfElements = ((noOfElements * 10) + Integer.parseInt(String.valueOf(compound.charAt(x + 1))));
                    x++;
                }

                noOfElements = noOfElements > 0 ? noOfElements : 1;

                System.out.println(noOfElements + " part/s " + element.keySet().iterator().next());
                compoundWeight += (element.values().iterator().next() * noOfElements);

            }
        }

        System.out.println("Atomic mass of " + compound + " is : " + compoundWeight);

    }
}