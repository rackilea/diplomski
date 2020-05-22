private String name;
Product  laptop = new Product(1, "Laptop", "Type", 1350.25, "black");
Product  mouse = new Product(2, "Mouse", "Type", 50.50, "black");

String check = new String("laptop");
if(check.equals(laptop.getName()) {
    System.out.println("Match!");
} else {
    System.out.println("No match...");
}