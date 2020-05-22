@SuppressWarnings("serial")
public class UsernameInvalidExcepton extends BaseException {

    @Override
    @SuppressWarnings("static-access")
    protected void initErrorCode() {

        this.errorCode = this.USERNAME_INVALID_EXCEPTIO_CODE;
    }

    public UsernameInvalidException(String message) {

        super(message);
    }