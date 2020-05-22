String message = "Recharge of Rs.196 for 9055668800 is successful. Recharge prepaid mobile instantly using freecharge app. hi, we have received payment of Rs.2000.00 with ref.no.NF789465132. Stay tuned while we confirm your booking.";
Pattern pattern = Pattern.compile("(?<=Rs.)\\d+[\\.\\d]*");
Matcher matcher = pattern.matcher(message);
double sum = 0;
while (matcher.find()) {
    String digit = matcher.group();
    System.out.println("digit = " + digit);
    sum += Double.parseDouble(digit);
}
System.out.println("sum = " + sum);