private static boolean validatePhoneNumber(String phoneNo) {
    // Check if phone number is valid format (optional -, . or space)
    // e.g. "1234567890", "123-456-7890", "123.456.7890", or "123 456 7890"
    // and is that all digits are not the same, e.g. "999-999-9999"
    return phoneNo.matches("(?!(\\d)\\1{2}\\D?\\1{3}\\D?\\1{4})\\d{3}([-. ]?)\\d{3}\\2\\d{4}");
}