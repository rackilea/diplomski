Pattern patternPaymentDetailOpen = Pattern.compile("<[a-zA-Z0-9]*:PaymentDetail>");
Pattern patternPaymentDetailClose = Pattern.compile("</[a-zA-Z0-9]*:PaymentDetail>");
Matcher matcherPaymentDetail = patternPaymentDetailOpen.matcher(input);
StringBuilder builder = new StringBuilder();
int pos = 0;
while (matcherPaymentDetail.find()) {
    builder.append(input, pos, matcherPaymentDetail.end());
    matcherPaymentDetail.usePattern(patternPaymentDetailClose);
    if (matcherPaymentDetail.find()) {
        builder.append(input, matcherPaymentDetail.start(), matcherPaymentDetail.end());
        pos = matcherPaymentDetail.end();
    }
    matcherPaymentDetail.usePattern(patternPaymentDetailOpen);
}
builder.append(input, pos, input.length());
System.out.println(builder.toString());