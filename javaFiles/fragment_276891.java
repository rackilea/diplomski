DecimalFormatSymbols dfs = new DecimalFormatSymbols();
    dfs.setDecimalSeparator('.');
    java.text.DecimalFormat df = new java.text.DecimalFormat();  
    df.setDecimalFormatSymbols(dfs);
    df.applyPattern( "###0.00" );
    String s = "9.90" ;
    System.out.println("non formated d=" + Double.valueOf(s) + " formated d=" +df.format(Double.valueOf(s)));