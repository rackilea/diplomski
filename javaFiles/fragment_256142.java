private static final ErrorCode[] allErrorCodes = new ErrorCode[] {
    null, MissingReturn, InvalidArgument
};

public static ErrorCode lookUpByCode(int code) {
    // Add range checking to see if the code is valid
    return allErrorCodes[code];
}