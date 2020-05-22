countries.stream().forEach(country -> {
   removeDuplicates(country); // prints out the letters without duplicates
                              // doesn't actually modify country,
                              // or return the deduplicated characters
   System.out.print(" ");
});