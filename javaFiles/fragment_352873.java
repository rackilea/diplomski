Set fruits =  new HashSet();

fruits.add("Apple");
fruits.add("Banana");
fruits.add("Orange");

String allFruits = StringUtils.join(fruits, ", ");
// allFruits is now "Apple, Banana, Orange"