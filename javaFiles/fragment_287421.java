// Step 1: Create Set of Strings
Set<String> allStrings = new HashSet<String>();
for (Item item : allList) {
   allStrings.add(item.getString());
}

// Step 2: Calculate occurrences
for (Item item : allList) {
   for (Item internalItem : item.getItems()) {
       if (allStrings.contains(internalItem.getString()) {
           // Count one up for this String
           // This might be done by replacing the HashSet by a HashMap and use its values for counting
       }
   }
}