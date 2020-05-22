public ProductRepositiryImpl() {
            listOfAllProducts = new LinkedList<>();

            Product iphone = new Product("A1232", "iPhone", new BigDecimal(500));
            iphone.setDescription("iPhone 6s with 5.2' FHD Screen");
            iphone.setManfactuer("Apple");
            iphone.setCategory("Smart Phone");
            iphone.setUnitsInStock(699);

            listOfAllProducts.add(iphone);
    }