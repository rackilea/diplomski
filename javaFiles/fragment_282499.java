JFormattedTextField ftf = new JFormattedTextField();
ftf.setFormatterFactory(new DefaultFormatterFactory(
                        new NumberFormatter(new DecimalFormat("#,##0.00"))));


// Input = 1245678.57
// After the format it will be:
// 1,245,678.57
// So, we need to get rid of the comma's:
String number = ftf.getText().replace(",","");
BigDecimal bd = new BigDecimal(number);