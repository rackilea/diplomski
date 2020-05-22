int[] counts = new int[14];
try {
  // ...
} catch (Exception e) {
   System.out.println("Exception: " + e.getMessage());
   e.printStackTrace();
}
for (int i = 0; i < counts.length; i++) { // <-- and arrays start at 0.
  System.out.print("Proportion of " + (i+1) + "-letter words: ");
  System.out.println("( " + counts[i] + " words )");
}