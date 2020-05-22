public static void main(String[] args) {
    double[] priceArray = {10.62, 14.89, 13.21, 16.55, 18.62, 9.47, 6.58, 18.32, 12.15, 3.98};
    double[] quantityArray = {4.0, 8.5, 6.0, 7.35, 9.0, 15.3, 3.0, 5.4, 2.9, 4.8};

    double[] amountArray = multiply(priceArray, quantityArray);
}

private static double[] multiply(double[] prices, double[] quantity) {
    double[] result = new double[prices.length + quantity.length];
    for (int k = 0; k < prices.length && k < quantity.length; k++) {
        result[k] = prices[k] * quantity[k];
    }
    return result;
}