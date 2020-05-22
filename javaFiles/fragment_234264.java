if (years != null && rate != null) {
    try {
        double rate = Double.parseDouble(rateString);
        double years = Double.parseDouble(yearsString);
        double outFloat = inFloat * Math.pow((1f + rate), years);
        return df2.format(outFloat);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}