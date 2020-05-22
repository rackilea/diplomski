double result = 0.0;
if (CurChoice.equals("EUR")) {
    result = ExcAmount / Euro;
//...
 } else {
    System.out.println("");
}

double commission = (yn ? 0.01 : 0.02)*result;
System.out.println( "commision: " + ... );
double netPayment = result - commission;