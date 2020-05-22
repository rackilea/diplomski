String msg1 = "Line : 1 Invoice does not foot Reported";
String msg2 = "Line : 2 Could not parse INVOICE_DATE value";
String msg5 = "Line 3 : Could not parse ADJUSTMENT_AMOUNT value";
String msg6 = "Line 4 : MATH ERROR";
System.out.println(msg1.matches("Line\\s(?:(\\d+)\\s)?\\s*:\\s+(\\d+)?(?!.*?\\bInvoice does not foot Reported).+"));
System.out.println(msg2.matches("Line\\s(?:(\\d+)\\s)?\\s*:\\s+(\\d+)?(?!.*?\\bInvoice does not foot Reported).+"));
System.out.println(msg5.matches("Line\\s(?:(\\d+)\\s)?\\s*:\\s+(\\d+)?(?!.*?\\bInvoice does not foot Reported).+"));
System.out.println(msg6.matches("Line\\s(?:(\\d+)\\s)?\\s*:\\s+(\\d+)?(?!.*?\\bInvoice does not foot Reported).+"));