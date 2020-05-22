enum ASN1Messages {
    /**
     * ASN.1 Boolean elements must have a value whose length is exactly one byte.
     */
    ERR_BOOLEAN_INVALID_LENGTH("ASN.1 Boolean elements must have a value whose length is exactly one byte."),


    /**
     * Unable to decode the provided byte array as an ASN.1 BER element:  {0}
     */
    ERR_ELEMENT_DECODE_EXCEPTION("Unable to decode the provided byte array as an ASN.1 BER element:  {0}"),;

    private String s;

    ASN1Messages(String s) {
        this.s = s;
    }

    /**
     * Retrieves a localized version of the message.
     * This method should only be used for messages which do not take any arguments.
     *
     * @return A localized version of the message.
     */
    public String get() {
        return s;
    }
}