class PhoneNotValidException extends RuntimeException {
    public PhoneNotValidException(String message) {
        super(message);
    }
}

public void validatePhoneNumber(String phone) {
    final String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
    if (!Pattern.matches(regexStr, phone)) {
        throw new PhoneNotValidException(phone);
    }
}