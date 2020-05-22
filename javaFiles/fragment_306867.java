/**
     * Returns a double with an adhoc formatting, compatible with its C counterpart
     * 
     * If the absolute value is not too small or too big (thresholdLow-thresholdHigh)
     * the floating format is used, elsewhere the scientific.
     * In addition 
     *  - trailing zeros in fractional part are removed
     *  - if the value (or mantisa) is integer, a trailing .0 is always included
     *  - the exponent in sci notation is two or three digits
     *  - positive and negative zero returns "0.0"
     *  - special vals: "NaN" "Infinite" "-Infinite"
     * 
     * Remember to set Locale.setDefault(Locale.US) in your program.
     * 
     * @param v double
     * @param formatFloat floating point format, suggested: "%.5f"
     * @param formatSci   scientific format, must use lowercase 'e' : "%.5e"   
     * @param thresholdLow 
     * @param thresholdHigh
     * @return formatted string
     */
    public static String sprintfDouble(double v, String formatFloat, String formatSci, double thresholdLow,
            double thresholdHigh) {
        if(v==0.0)
            return "0.0"; //dont care about negative zero 
        if(Double.isInfinite(v) || Double.isNaN(v))
            return String.format(formatFloat,v);

        boolean neg = false;
        if (v < 0) {
            v = -v;
            neg = true;
        }
        String e = "";
        String res;
        if (v > thresholdLow && v < thresholdHigh) {
            res = String.format(formatFloat, v);
        } else {
            res = String.format(formatSci, v);
            int sp = res.indexOf('e');
            e = res.substring(sp);
            res = res.substring(0, sp);
        }
        if (res.indexOf('.') < 0)
            res += "."; // add decimal point if not present
        res = res.replaceAll("0+$", ""); // trim trailing zeros 
        if (res.endsWith("."))
            res += "0"; // add traiing zero if nec
        res += e;
        if (neg)
            res = "-" + res;
        return res;
    }

    public static String sprintfDouble5(double v){
        return sprintfDouble(v, "%.5f","%.5e",0.01,1000000.0);
    }