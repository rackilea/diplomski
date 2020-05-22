Hashmap<String, Boolean> merged =new Hashmap<>();

 for(Product product : masterList)
       Merged.put(product.getName(), product.isfiltered());

 for(Product product : filteredList)
       Merged.put(product.getName(), product.isfiltered());