double totalCost = 0;
for (String item: cart.keySet()) {
    double amount = cart.get(item);
    double price = stock.get(item);
    totalCost += amount * price; 
}
return totalCost;