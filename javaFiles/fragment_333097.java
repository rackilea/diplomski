class Main {
  public static String convertTemp (float temperature, char convertTo) {
    if (convertTo == 'F') {
      return String.format("The temperature in Fahrenheit is %.1f", (9*temperature/5 + 32)); 
    } else if (convertTo == 'C') {
      return String.format("The temperature in Celsius is %.2f", (temperature - 32) * 5/9); 
    } else {
      return "You can enter either F or C as convertTo argument";
    }
  }

  public static void main(String[] args) {
    System.out.println("Converting 21C to Fahrenheit. " +  convertTemp(21,'F'));
    System.out.println("Converting 70F to Celsius. " + convertTemp(70,'C'));
  }
}