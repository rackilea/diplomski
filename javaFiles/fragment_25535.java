Double d = 456.67d;
BigDecimal bd = new BigDecimal( d );
bd.setScale( 50 );
System.out.println( bd );
DecimalFormat formatter = new DecimalFormat("0.000000000000000000000E000");
System.out.println( formatter.format( bd ) );