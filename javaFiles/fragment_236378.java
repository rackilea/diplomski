public class Product {
    private String name;
    private double price;
    private Date produced;
    private Shop shop;
    // Optional Getters and setters. GSON uses reflection, it doesn't need them
    // However, better declare them so that you can access the fields
}

public class Shop {
   private String name;
    // Optional Getters and setters. GSON uses reflection, it doesn't need them
    // However, better declare them so that you can access the fields
}