private static double stripCurrency(String sBudget) {
        //to handle strings with no dollar sign.
        if(sBudget.trim().charAt(0) != '$') {
            sBudget = "$"+sBudget;
        }
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
        Number parse = null;
        try {
            parse = formatter.parse(sBudget);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return parse.doubleValue();
    }