// Somewhere up in your code -- Sorry, fixed up your regex
private static final Pattern BARCODE=Pattern.compile("^\\d{12}$");
public static boolean isValidBarcode(String candidate) {
    return BARCODE.matcher(candidate).matches();
}

// Now your "real" code
case "A":

    Item item = new Item();
    System.out.print("Enter a barcode: ");
    barCode = scan.nextLine();
    if(isValidBarCode(barCode)) {
        item.setBarCode(barCode);
        if(store.addItem(barCode)) {
            System.out.println(store.stockedItems.get(barCode).getProductName() + " has been added to the store's inventory");
        }
        else {
            item.setQuantity(1);
            System.out.print("Enter the item's name: ");
            productName = scan.nextLine();
            productName = productName.toLowerCase();
            item.setProductName(productName);
            store.stockedItems.put(barCode, item);

            System.out.println(store.stockedItems.get(barCode).getProductName() + " has been added to the store's inventory");
        }
    }
    else {
        System.out.println("That's not a valid bar code.");
    }
    break;

// And, finally, your setBarCode() method
public void setBarCode(String code) {
    assert isValidBarCode(code);
    barcode = code;
}