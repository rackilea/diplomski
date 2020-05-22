final double MILES_PER_KM = 1.61; // miles per km
System.out.printf("%s\t%s%n", "Miles/hr", "Km/hr");
for (int miles = 1; miles <= 11; miles += 2) {
    double km = miles * MILES_PER_KM;
    System.out.printf("%3d\t\t%3.2f%n", miles, miles * MILES_PER_KM);
}