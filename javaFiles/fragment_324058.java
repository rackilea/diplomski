enum Status { 
    SUCCESS("Success"), 
    BAD_PATH("The directory does not contain the required file"),
    HAS_THE_LETTER_C("The directory must not contain the letter C");

    private final String message;
    private Status(String _message) {
        message = _message;
    };

    @Override
    public String toString() { 
        return message;
    }
}