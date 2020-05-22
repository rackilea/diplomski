public class StringTest {

public static void main(String[] args) {
    String stringTest = "En esta cadena tenemos mas cadenas que la cadena principal la primera vez que intente esta solucion no pude mas que intentar una y otra vez vez vez vez";
    new StringTest(stringTest);

}

public StringTest(String string) {

    String[] splitString = string.split(" ");

    Map<String, Integer> mapString = new HashMap<String, Integer>();

    // Loop the array
    for (String token : splitString) {
        // Convert token to lowerCase
        token = token.toLowerCase();
        if (mapString.containsKey(token)) {
            mapString.put(token, mapString.get(token) + 1);
        } else {
            mapString.put(token, 1);
        }
    }

    // Convert Map to List of Map
    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(mapString.entrySet());

    // Sort list with Collections.sort(), provide a custom Comparator
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            // o2 first that the order was descendant
            return (o2.getValue()).compareTo(o1.getValue());
        }
    });

    System.out.println("The most concurrent Word: " + list.get(0).getKey());
    System.out.println("The second word is: " + list.get(1).getKey() + ", an third is: " + list.get(2).getKey());
    System.out.println("The top concurrent words are");

    for (Entry<String, Integer> entry : list) {
        if (entry.getValue() > 1) {
            System.out.println(entry);

        }
    }
}