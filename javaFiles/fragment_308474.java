String line = fileScanner.nextLine();
String[] parts = line.split(",\\s+");
if (parts[0].equalsIgnoreCase("pet bunny")) {
    String name = parts[1];
    String breed = parts[2];
    double weight = Double.parseDouble(parts[3]);
    PetBunny pB = new PetBunny(name, breed, weight);
    addBunny(pB);
}
// and other cases