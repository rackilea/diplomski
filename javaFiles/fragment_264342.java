public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numOfProducts;
    String productName;
    double productPrice;

    System.out.println("Enter the number of products:");
    numOfProducts = scan.nextInt();
    //Create an array of Products using the user value stored in numOfProducts
    Product[] products = new Product[numOfProducts];

    //Loop over products, and initialize each space with a new product
    for (int i = 0; i < products.length; i++) {
        System.out.println("Enter the name of product:");
        productName = scan.next();

        System.out.println("Enter the price:");
        productPrice = scan.nextDouble();

        products[i] = new Product(productName, productPrice);
    }
}