// Print the header.
System.out.printf("%s %s%n", pad("Year", 12), "Future Value");
for (int y = 1; y <= 30; y++) {
    String year = pad(String.valueOf(y), 13); // <-- One more in your alignment.
    String fv = String.format("$%.2f", futureInvestmentValue(i,r,y));
    System.out.printf("%s %s%n", year, fv);
}