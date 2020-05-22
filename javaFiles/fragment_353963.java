private DecimalFormatSymbols dfs;
private DecimalFormat dFormat;

dfs = new DecimalFormatSymbols();
dfs.setDecimalSeparator('.'); //separator for the decimals
dfs.setGroupingSeparator(','); //separator for the thousands
dFormat = new DecimalFormat ("#0.##", dfs);

JFormattedTextField ftf = new JFormattedTextField(dFormat);