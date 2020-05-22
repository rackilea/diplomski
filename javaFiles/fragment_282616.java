public static void main(String[] args) {
    String currencyValues = "45,890.00,12,345.00,23,765.34,56,908.50";
    String regEx = "(?<=\\.[0-9]{2}),"; // Using the regex with the look-behind
    String[] results = currencyValues.split(regEx);
    for (String res : results) {
        System.out.println(res);
    }
}