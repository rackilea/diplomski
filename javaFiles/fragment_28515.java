public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double f = sc.nextDouble();
    double c = sc.nextDouble();

    double cResult = toCelsius(f);
    System.out.println(f + "°F is " + cResult + "°C");

    double fResult = toFahrenheit(c);
    System.out.println(c + "°C is " + fResult + "°F");
}