public class BaseException extends RuntimeException {

    protected static final String SCANPAY_EXCEPTION_CODE = "300";

    protected static final String BASE_EXCEPTION_CODE = "400";        

    protected static final String USERNAME_INVALID_EXCEPTION_CODE = "405";

    protected static final String DAO_EXCEPTION_CODE = "401";

    protected static final String SERVICE_NOT_AVAILABLE_CODE = "414";

    protected static final String PARAMETER_ERROR_CODE = "402";

    protected String errorCode;

    public BaseException() {

        initErrorCode();
    }

    public BaseException(String message) {

        super(message);
        initErrorCode();
    }

    public BaseException(Throwable cause) {

        super(cause);
        initErrorCode();
    }

    public BaseException(String message, Throwable cause) {

        super(message, cause);
        initErrorCode();
    }

    public BaseException(String message, Throwable cause,
        boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
        initErrorCode();
    }

    protected void initErrorCode() {

        errorCode = BASE_EXCEPTION_CODE;
    }

    public String getErrorCode() {

        return errorCode;
    }

}