public static void main(String[] args) {
    Double[] priceArray = {10.62, 14.89, 13.21, 16.55, 18.62, 9.47, 6.58, 18.32, 12.15, 3.98};
    Double[] quantityArray = {4.0, 8.5, 6.0, 7.35, 9.0, 15.3, 3.0, 5.4, 2.9, 4.8};

    List<Double> priceList = Arrays.asList(priceArray);
    List<Double> quantityList = Arrays.asList(quantityArray);
    List<Double> amountList = multiply(priceList, quantityList);
}

private static List<Double> multiply(List<Double> prices, List<Double> quantity) {
    List<Double> result = new ArrayList<Double>();
    for (int k = 0; k < prices.size() && k < quantity.size(); k++) {
        result.add(prices.get(k) * quantity.get(k));
    }
    return result;
}