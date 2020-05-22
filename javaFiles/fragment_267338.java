Product[] products = // your products.
Product mostExpensiveProduct = product[0];

for (Product product : products) {
  if (product.getPrice() > mostExpensiveProduct.getPrice()) {
    mostExpensiveProduct = product;
  }
}

System.out.println("Most expensive product is " + mostExpensiveProduct.getName() + " with price " + mostExpensiveProduct.getPrice());