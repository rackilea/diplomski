private static Map<Product,String> sortingUsingTreeMap(Map<Product,String> descriptionByProducts){
final Map<Product,String> sortedMap = new TreeMap<Product,String>(new ProductComparator());
for(Map.Entry<Product, String> element:descriptionByProducts.entrySet()) {
    sortedMap.put(element.getKey(), element.getValue());
}

sortedMap.putAll(descriptionByProducts);
return sortedMap;