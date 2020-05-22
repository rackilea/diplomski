Scanner priceScan = new Scanner(new File(priceList));
HashMap<String, Double> prices = new HashMap<String, Double>();
while (priceScan.hasNext()) {
    String name = priceScan.next();
    Double price = priceScan.nextDouble();
    prices.put(name, price);
}
priceScan.close();