public class ServiceException {

    public ServiceException(int errorCode) {
        // do stuff
    }

    public ServiceException(ErrorCodeEnum errorCodeEnum) {
        this(errorCodeEnum.getErrorCode());
    }

}