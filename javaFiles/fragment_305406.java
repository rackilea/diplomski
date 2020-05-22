/**
 * Provides handling for standard Spring MVC exceptions.
 * @param ex the target exception
 * @param request the current request
 */
@ExceptionHandler({
        HttpRequestMethodNotSupportedException.class,
        HttpMediaTypeNotSupportedException.class,
        HttpMediaTypeNotAcceptableException.class,
        MissingPathVariableException.class,
        MissingServletRequestParameterException.class,
        ServletRequestBindingException.class,
        ConversionNotSupportedException.class,
        TypeMismatchException.class,
        HttpMessageNotReadableException.class,
        HttpMessageNotWritableException.class,
        MethodArgumentNotValidException.class,
        MissingServletRequestPartException.class,
        BindException.class,
        NoHandlerFoundException.class,
        AsyncRequestTimeoutException.class
    })
@Nullable
public final ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();
    if (ex instanceof HttpRequestMethodNotSupportedException) {
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        return handleHttpRequestMethodNotSupported((HttpRequestMethodNotSupportedException) ex, headers, status, request);
    }
    else if (ex instanceof HttpMediaTypeNotSupportedException) {
        HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        return handleHttpMediaTypeNotSupported((HttpMediaTypeNotSupportedException) ex, headers, status, request);
    }
    else if (ex instanceof HttpMediaTypeNotAcceptableException) {
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        return handleHttpMediaTypeNotAcceptable((HttpMediaTypeNotAcceptableException) ex, headers, status, request);
    }
    else if (ex instanceof MissingPathVariableException) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return handleMissingPathVariable((MissingPathVariableException) ex, headers, status, request);
    }
    else if (ex instanceof MissingServletRequestParameterException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleMissingServletRequestParameter((MissingServletRequestParameterException) ex, headers, status, request);
    }
    else if (ex instanceof ServletRequestBindingException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleServletRequestBindingException((ServletRequestBindingException) ex, headers, status, request);
    }
    else if (ex instanceof ConversionNotSupportedException) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return handleConversionNotSupported((ConversionNotSupportedException) ex, headers, status, request);
    }
    else if (ex instanceof TypeMismatchException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleTypeMismatch((TypeMismatchException) ex, headers, status, request);
    }
    else if (ex instanceof HttpMessageNotReadableException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleHttpMessageNotReadable((HttpMessageNotReadableException) ex, headers, status, request);
    }
    else if (ex instanceof HttpMessageNotWritableException) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return handleHttpMessageNotWritable((HttpMessageNotWritableException) ex, headers, status, request);
    }
    else if (ex instanceof MethodArgumentNotValidException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleMethodArgumentNotValid((MethodArgumentNotValidException) ex, headers, status, request);
    }
    else if (ex instanceof MissingServletRequestPartException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleMissingServletRequestPart((MissingServletRequestPartException) ex, headers, status, request);
    }
    else if (ex instanceof BindException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleBindException((BindException) ex, headers, status, request);
    }
    else if (ex instanceof NoHandlerFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return handleNoHandlerFoundException((NoHandlerFoundException) ex, headers, status, request);
    }
    else if (ex instanceof AsyncRequestTimeoutException) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return handleAsyncRequestTimeoutException(
                (AsyncRequestTimeoutException) ex, headers, status, request);
    }
    else {
        if (logger.isWarnEnabled()) {
            logger.warn("Unknown exception type: " + ex.getClass().getName());
        }
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return handleExceptionInternal(ex, null, headers, status, request);
    }
}