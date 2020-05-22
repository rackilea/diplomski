public static String addCommas(int num) {
    DecimalFormat df = new DecimalFormat();
    DecimalFormatSymbols dfs = new DecimalFormatSymbols();
    dfs.setGroupingSeparator(',');
    df.setDecimalFormatSymbols(dfs);
    return df.format(num);
}

System.out.println(addCommas(123456789));