public class TestClass {

public static void main(String[] args) {
    String input = "TAX|CHURCH, Texas, San Antonia, 250.00 | SCHOOL, NEVADA, Park-SCHOOL, 122.1";
    String[] parts = input.split(" \\| ");
    String result = parts[0].split("CHURCH, ")[1];

    if (parts.length > 1) {
        result += ", " + parts[1].substring(8); 
    }

    System.out.println(result);
}

}