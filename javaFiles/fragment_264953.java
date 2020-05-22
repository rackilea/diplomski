for(int i = 0; i < items.length; i++) {
  // Handle item
  r += "\n";
  r += String.format("%-15.15s", items[i]);

  // Handle price
  r += String.format("%6.2f", prices[i]);

}