public static String parseToCientificNotation(double value) {
        int cont = 0;
        java.text.DecimalFormat DECIMAL_FORMATER = new java.text.DecimalFormat("0.##");
        while (((int) value) != 0) {
            value /= 10;
            cont++;
        }
        return DECIMAL_FORMATER.format(value).replace(",", ".") + " x10^ -" + cont;
}