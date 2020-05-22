Map<Integer, Map<String, List<Product>>> newMap = new HashMap<Integer, Map<String, List<<Product>>>();
for (Product product: productList) {
   if (!newMap.containsKey(product.year)) // Java should do auto-boxing here 
        newMap.put(product.year, new HashMap<String, Product>());
   if (!newMap.get(product.year).containsKey(product.manufacturingArea);
        newMap.get(product.year).put(product.manufacturingArea, new ArrayList<Product>());

   newMap.get(product.year).get(product.manufacturingArea).add(product));
}