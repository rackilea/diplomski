public String decimalDigits(int decimaldigits, float x){
        final NumberFormat numFormat = NumberFormat.getNumberInstance();
        numFormat.setMaximumFractionDigits(decimaldigits);
        final String resultS = numFormat.format(x);
        return resultS;
    }