Map<int, Set<Product>> productsById = new HashMap<>();
for (int i = 0; i < pumpno.length; i++) {
    if (productsById.containsKey(pumpno[i])) {
      //add product to existing set
      productsById.get(pumpno[i]).add(new Product(desc[i], cost[i]));
    } else {
        //create set since this is first time id is shown
        Set<Product> set = new HashSet<Product>();
        set.add(new Product(desc[i], cost[i]);
        productsById.put(pumpno[i], set);
    }
}

String newLine = System.getProperty("line.separator"); 
for (int id : productsById.keySet()){
   System.out.println("id " + id + newLine);
   for (Product product : productsById.get(id)){
     System.out.println("description" + product.getDescription() + newLine);
     System.out.println("cost" + product.getCost() + newLine);   
   }
}