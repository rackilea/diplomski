public static void main(String... args) throws ParseException {
    DecimalFormatSymbols dfs1 = new DecimalFormatSymbols();
    dfs1.setDecimalSeparator('.');
    dfs1.setGroupingSeparator(',');

    DecimalFormat df1 = new DecimalFormat("#,##0.00", dfs1);
    System.out.println(df1.format(-10000)+" parsed is "+df1.parse("-10,000.01"));

    DecimalFormatSymbols dfs2 = new DecimalFormatSymbols();
    dfs2.setDecimalSeparator(',');
    dfs2.setGroupingSeparator('.');

    DecimalFormat df2 = new DecimalFormat("#,##0.00", dfs2);
    System.out.println(df2.format(-10000)+" parsed is "+df2.parse("-10.000,01"));
}