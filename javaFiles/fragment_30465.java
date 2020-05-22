public static double computeProfit(HashMap<String, double> sellingPrice, HashMap<String, double> inventory, ArrayList<HashMap<String, int>> orders) {
    double profit = 0;
    for (HashMap<String, int> order: Orders) {
        for (Map.Entry<String, int> orderEntry: order.entrySet()) {
            double purchasePrice = inventory.get(orderEntry.getKey());
            double salePrice = sellingPrice.get(orderEntry.getKey());
            int purchaseCount = orderEntry.getValue();
            profit += ( salePrice - purchasePrice ) * purchaseCount;
        }
    }
    return profit;
}