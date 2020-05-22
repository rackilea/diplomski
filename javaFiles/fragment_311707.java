private void subscribe() throws JMSException {

    // get context / create connection and session / etc.
    TopicConnection connection = ...

    connection.setExceptionListener(this::handleExceptions);
    connection.start();
}