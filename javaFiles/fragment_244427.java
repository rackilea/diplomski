private int numStrings;
private double guitarLength;
private String guitarManufacturer;
private Color guitarColor;
private static int i = 1;
private static Random rand = new Random();

// declaring the constructor
public Guitar() {
    this.numStrings = 6;
    this.guitarLength = 28.2;
    this.guitarManufacturer = "Gibson";
    this.guitarColor = Color.RED;
}

public Guitar(int strings, double length, String manufacturer, Color color) {
    this.numStrings = strings;
    this.guitarLength = length;
    this.guitarManufacturer = manufacturer;
    this.guitarColor = color;
    System.out.printf("toString: %s \n ", this);
}