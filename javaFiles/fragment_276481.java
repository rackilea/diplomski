catch (ListenerExecutionFailedException e) {
        if (this.errorHandler != null) {
            try {
                Object result = this.errorHandler.handleError(message, e, consumer);
                if (result != null) {
                    handleResult(result, record, message);
                }
            }
            catch (Exception ex) {
                throw new ListenerExecutionFailedException(createMessagingErrorMessage(
                        "Listener error handler threw an exception for the incoming message",
                        message.getPayload()), ex);
            }
        }
        else {
            throw e;
        }
    }