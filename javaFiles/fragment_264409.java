import java.util.Arrays;
import java.util.Comparator;

public class AppInventoryPro2 {

    public static void main(String... args) {

        System.out.println("Mobile Phone Inventory Program");
        System.out.println();// skips a line

        MobilePhone[] phones = new MobilePhone[5];

        phones[0] = new MobilePhone();
        phones[0].setproductNumber(1);
        phones[0].setname("Motorola");
        phones[0].setdepartment("Electronics");
        phones[0].setunitPrice(150.10);
        phones[0].setunitsInStock(98);

        phones[1] = new MobilePhone();
        phones[1].setproductNumber(2);
        phones[1].setname("Samsung");
        phones[1].setdepartment("Electronics");
        phones[1].setunitPrice(199.99);
        phones[1].setunitsInStock(650);

        phones[2] = new MobilePhone();
        phones[2].setproductNumber(3);
        phones[2].setname("Nokia");
        phones[2].setdepartment("Electronics");
        phones[2].setunitPrice(200.25);
        phones[2].setunitsInStock(125);

        phones[3] = new MobilePhone();
        phones[3].setproductNumber(4);
        phones[3].setname("LG");
        phones[3].setdepartment("Electronics");
        phones[3].setunitPrice(100.05);
        phones[3].setunitsInStock(200);

        phones[4] = new MobilePhone();
        phones[4].setproductNumber(5);
        phones[4].setname("IPhone");
        phones[4].setdepartment("Electronics");
        phones[4].setunitPrice(299.99);
        phones[4].setunitsInStock(150);

        System.out.println("Order of inventory before sorting:");
        System.out.println(Arrays.toString(phones));

        Arrays.sort(phones, new Comparator<MobilePhone>() {
            @Override
            public int compare(MobilePhone mp1, MobilePhone mp2) {
                return mp1.getname().compareTo(mp2.getname());
            }
        });

        System.out.println("Order of inventory after sorting by name:");
        System.out.println(Arrays.toString(phones));
    }
}

class MobilePhone {

    private double productNumber; // Variables
    private String name;
    private String department;
    private double unitsInStock;
    private double unitPrice;

    public MobilePhone() {
        this(0.0, "", "", 0.0, 0.0);
    }

    public MobilePhone(double productNumber, String name, String department,
            double unitsInStock, double unitPrice) { // assign variables
        this.productNumber = productNumber;
        this.name = name;
        this.department = department;
        this.unitsInStock = unitsInStock;
        this.unitPrice = unitPrice;
    }

    public double getproductNumber() { // retrieve values
        return productNumber;
    }

    public String getname() {
        return name;
    }

    public String getdepartment() {
        return department;
    }

    public double getunitPrice() {
        return unitPrice;
    }

    public double getunitsInStock() {
        return unitsInStock;
    }

    public void setproductNumber(double productNumber) {
        this.productNumber = productNumber;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setdepartment(String department) {
        this.department = department;
    }

    public void setunitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setunitsInStock(double unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public double gettotalInv() {
        return getunitPrice() * getunitsInStock();
    }

    @Override
    public String toString() {
        return "MobilePhone [productNumber=" + productNumber + ", name=" + name
                + ", department=" + department + ", unitsInStock="
                + unitsInStock + ", unitPrice=" + unitPrice + "]";
    }
}