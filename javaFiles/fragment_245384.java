// Add to the ThreadContext map for this try block only;
try (final CloseableThreadContext.Instance ctc = CloseableThreadContext
        .put("id", UUID.randomUUID().toString())
        .put("loginId", session.getAttribute("loginId"))) {
    logger.debug("Message 1");
    // call some other code that also does logging 
    ...
    logger.debug("Message 2");
    ...
} // "id" and "loginId" are now removed from the ThreadContext map