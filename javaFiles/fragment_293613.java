// Your decimal value
double n = 0.12876543;
// Decimal Formatting
DecimalFormat curDf = new DecimalFormat(".00");
// This will set the RoundingMode
curDf.setRoundingMode(RoundingMode.DOWN);
// Print statement
System.out.println(curDf.format(n));