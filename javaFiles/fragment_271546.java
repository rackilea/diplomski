public float decimalDigits(int decimaldigits, float x){
            final NumberFormat numFormat = NumberFormat.getNumberInstance();
            numFormat.setMaximumFractionDigits(decimaldigits);
            final String resultS = numFormat.format(x);
            String parsable=resultS.replace(".", "");
            parsable=resultS.replace(",", ".");
            float ris=Float.parseFloat(parsable);
            return ris;
        }