package myLibrary;

public class Item {

    protected String barcode;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Item(String barcode) {
        this.barcode = barcode;
    }
}