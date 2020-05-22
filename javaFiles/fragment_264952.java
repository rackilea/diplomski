for(String item : items) {
  r += "\n";
  r += String.format("%-15.15s", item);         
}
for(double price: prices) {
  r += String.format("%6.2f", price);
}