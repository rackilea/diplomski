private static final String HORNETQ_DISCONNECT_ERROR_CODE = "DISCONNECT";

private void handleExceptions(final JMSException jmsException) {

    final String errorCode = jmsException.getErrorCode();
    if (HORNETQ_DISCONNECT_ERROR_CODE.equals(errorCode)) {
        tryConnect();
    }
}