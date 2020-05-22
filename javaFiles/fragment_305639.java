try {
    IPAddressString str = new IPAddressString("::1");
    IPAddress addr = str.toAddress();
} catch(IPAddressStringException e) {
    //e.getMessage has validation error
}