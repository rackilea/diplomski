Collection<String> subList1 = Arrays.asList("amulet", "map", "stone", "sword");
Collection<String> subList2 = Arrays.asList("bottle", "shield", "wand");

// Merge two collection in a single list    
List<String> mergedList = new ArrayList<>(subList1);
mergedList.addAll(subList2);

Collections.sort(mergedList);

// Assign subList from mergedList back to original Collection reference
subList1 = mergedList.subList(0, subList1.size());
subList2 = mergedList.subList(subList1.size(), mergedList.size());

System.out.println(subList1);  // [amulet, bottle, map, shield]
System.out.println(subList2);  // [stone, sword, wand]