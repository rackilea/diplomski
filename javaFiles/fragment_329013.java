final class Content<T> {

    private final boolean isSuccess;
    private final T data;
    private final ApiError error;

    private Content(final boolean isSuccess, final T data, final ApiError error) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.error = error;
    }

    static <T> Content<T> success(final T data) {
        return new Content<>(true, data, null);
    }

    static <T> Content<T> error(final ApiError error) {
        return new Content<>(false, null, error);
    }

    boolean isSuccess() {
        return isSuccess;
    }

    T getData()
            throws IllegalStateException {
        if ( !isSuccess ) {
            throw new IllegalStateException();
        }
        return data;
    }

    ApiError getError()
            throws IllegalStateException {
        if ( isSuccess ) {
            throw new IllegalStateException();
        }
        return error;
    }

}