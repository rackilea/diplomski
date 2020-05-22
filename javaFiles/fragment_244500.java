String swissNumberStr = "044 668 18 00";
PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
try {
    PhoneNumber swissNumberProto = phoneUtil.parse(swissNumberStr, "CH");
} catch (NumberParseException e) {
    e.printStackTrace();
}

// Produces "044 668 18 00"
System.out.println(phoneUtil.format(swissNumberProto, 
    PhoneNumberFormat.NATIONAL));