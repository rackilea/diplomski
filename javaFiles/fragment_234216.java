public static String GENERAL_OTP_TEMPLATE = "Your verification code: (.*).";

SmsMessage[] message = new SmsMessage[objectArray.length];
for (int i = 0; i < objectArray.length; i++) {
    message[i] = SmsMessage.createFromPdu((byte[]) objectArray[i]);

}
Pattern generalOtpPattern = Pattern.compile(GENERAL_OTP_TEMPLATE);
Matcher generalOtpMatcher = generalOtpPattern.matcher(message[0].getMessageBody().toString());

if (generalOtpMatcher.find()) {
       String otp = generalOtpMatcher.group(1);
       number.setText(otp);
}