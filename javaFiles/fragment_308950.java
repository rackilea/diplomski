import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<String, Double> inputs = new HashMap<String, Double>();

    boolean isNumber = true;
    int count = 1;
    while(isNumber) {
      System.out.printf("Please enter a%d:", count);
      if(scanner.hasNextDouble()) {
        inputs.put("a" + count,  scanner.nextDouble());
        count++;
      } else {
        isNumber = false;
      } 
    }

    System.out.println("Inputs: " + inputs);

    // Auxiliary code for question in comments below
    double sum = 0.0f;
    for (double d : inputs.values()) {
      sum += d;
    }

    System.out.println("Sum: " + sum);

    for (Map.Entry<String, Double> entry : inputs.entrySet()) {
      System.out.println("Sum - " + entry.getKey() + " = " + (sum  - entry.getValue()));
    }
  }
}