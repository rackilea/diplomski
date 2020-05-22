Message<?> reply = this.sendAndReceiveMessage(message);
if (reply == null) {
    if (logger.isDebugEnabled()) {
        logger.debug("null reply received for " + message + " nothing to send");
    }
    return false;
}