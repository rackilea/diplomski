public class Inventory {
    private String item;
    private String number;
    private double price;
    private double stock;
    private double resist;

    public Inventory(String[] csvLine) {
        if (csvLine.length > 0) item = csvLine[0];
        if (csvLine.length > 1) number = csvLine[1];
        if (csvLine.length > 2) stock = Double.parseDouble(csvLine[2]);
        if (csvLine.length > 3) price = Double.parseDouble(csvLine[3]);
        if (csvLine.length > 4) resist = Double.parseDouble(csvLine[4]);
    }
    // getters and setters
}