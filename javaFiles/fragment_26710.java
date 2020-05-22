/**
 * Parses addresses and re-encodes them in a way that won't cause {@link MimeMessage}
 * to freak out. This appears to be the only robust way of sending mail to recipients
 * with non-ASCII names. 
 * 
 * @param addresses  The usual comma-delimited list of email addresses.
 */
InternetAddress[] unicodifyAddresses(String addresses) throws AddressException {
    InternetAddress[] recips = InternetAddress.parse(addresses, false);
    for(int i=0; i<recips.length; i++) {
        try {
            recips[i] = new InternetAddress(recips[i].getAddress(), recips[i].getPersonal(), "utf-8");
        } catch(UnsupportedEncodingException uee) {
            throw new RuntimeException("utf-8 not valid encoding?", uee);
        }
    }
    return recips;
}