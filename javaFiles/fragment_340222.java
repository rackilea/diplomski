List<Product> products = buildProductsList();
   Map<String, List<Product>> productsGroupedByName = products.stream()
      .collect(Collectors.groupingBy(Product::getName));
   for(String name : productsGroupedByName.keySet()) {
      System.out.println("The name is: " + name);
      for (Product product : productsGroupedByName.get(name)) {
          // do something with the products
      }
   }