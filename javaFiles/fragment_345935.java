public SMSDataModelList(String message) {
    this(message, DEFAULT_MAX_NUM_PHONE_NUMBERS, false);
}   

public SMSDataModelList() {
    this("", DEFAULT_MAX_NUM_PHONE_NUMBERS, false);
}

public SMSDataModelList(String initialMessage, int maxNumPhoneNumbers) {
    this(initialMessage, maxNumPhoneNumbers, true);
}

public SMSDataModelList(String initialMessage, int maxNumPhoneNumbers, boolean limited) {
    this.message = initialMessage;
    this.maxNumPhoneNumbers = maxNumPhoneNumbers;
    this.phoneNumbers = new String[maxNumPhoneNumbers];
    this.limited = limited;
}