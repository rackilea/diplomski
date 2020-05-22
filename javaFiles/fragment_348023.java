public class getInvoiceAmount { public static void main(String[] args) {

    Invoice invoice1 = new Invoice();
    Invoice invoice2 = new Invoice();
    Invoice invoice3 = new Invoice();
    Invoice invoice4 = new Invoice();
    // display initial balance of each object

    System.out.printf("Part number is: %s\n", invoice1.getpartNumber());
    System.out.printf("Part description: %s\n", invoice2.getpartDescription());
    System.out.printf("Part price: %.2f\n", invoice3.getpriceperitem());
    System.out.printf("Part number is: %d\n", invoice4.getitemBeingPurchesed());

    // create a Scanner to obtain input from the command window
    Scanner input = new Scanner(System.in);


    System.out.print("Enter the Part number:"); // prompt
    String partNumber = input.nextLine(); // obtain user input
    invoice1.setPartNumber( partNumber);

    System.out.print("Enter the part description:"); // prompt
    String partDescription = input.nextLine(); // obtain user input

    System.out.print("Enter the quantity of items :"); // prompt
    int itemBeingPurchesed = input.nextInt(); // obtain user input

    System.out.print("Enter the pric per item·with cents in decimalse:"); // prompt
    double priceperitem = input.nextDouble(); // obtain user input

    System.out.printf("Toatal for items: %.2f\n", invoice1.getinvoiceAmount());

    }
}


class Invoice {

    private String partNumber; // instance variable
    private String partDescription; // instance variable
    private double priceperitem; // double va1rible
    private int itemBeingPurchesed;// used to total
    private double invoiceAmount;// double that adds invoice amount


    public Invoice(){

    }
    // Part Number
    public Invoice (String partNumber,String partDescription,double priceperitem,
            int itemBeingPurchesed,double invoiceAmount)

    {this.partNumber = partNumber;// assign it to instance variable name
     // method to get the part number
    }

    {this.partDescription = partDescription;// assign it to instance variable name
     // method to get the part number
    }

    // Part Price
    // validate that the priceperitem is greater than 0.0; if it is not,
    // instance variable priceperitem keeps its default initial value of 0.0
    public void setpriceperitem(double priceperitem) {
        if (priceperitem > 0.0) {// if the balance is valid
            this.priceperitem = priceperitem; // assign it to instance variable balance
        }
    }

    // Item purchased
    // validate that the itemBeingPurchesed is greater than 0; if it is not,
    // instance variable itemBeingPurchesed keeps its default initial value of 0
    public void setitemBeingPurchesed(int itemBeingPurchesed) {
        if (itemBeingPurchesed > 0) {// if the balance is valid
            this.itemBeingPurchesed = itemBeingPurchesed;// assign it to instance variable balance
        }
    }

    // getInvoiceAmount multiply the total if nothing or negative it sets to 0
    public void invoiceAmount(double invoiceAmount) {
        if (invoiceAmount > 0) {// if the balance is valid
            invoiceAmount = itemBeingPurchesed * priceperitem; // assign it to instance variable balance
        }
    }

    public void setPartNumber(String part_number){
        partNumber = part_number;
    }

    // method that returns the partDescription
    public String getpartNumber() {
        return partNumber;
    }

    // method that returns the partDescription
    public String getpartDescription() {
        return partDescription;
    }

    // method returns the account priceperitem
    public double getpriceperitem() {
        return priceperitem;
    }

    public int getitemBeingPurchesed() {
        return itemBeingPurchesed;

    }

    // method returns the account priceperitem
    public double getinvoiceAmount() {
        return invoiceAmount;
    }
}