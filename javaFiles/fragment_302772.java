Map<String, List<Product>> newMap = new HashMap<String, List<Product>>();

for (Product product: productList) {
   if (!newMap.containsKey(product.name)) 
        newMap.put(product.name, new ArrayList<Product>())
   newMap.get(product.name).add(product)
}