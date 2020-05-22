try {
    // code that might throw AddressException
} catch (SMTPAddressFailedException ex) {
    // Catch subclass of AddressException  first
    //  ...
} catch (AddressException ex) {
    // ...
}