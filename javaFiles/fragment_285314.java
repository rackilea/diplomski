try {
    return getEJBService().getServiceResult(param, param, param);
} catch (RuntimeException e) {
    Throwable cause = e.getCause();
    if (cause instanceof InterruptedException)
        throw (InterruptedException)cause;
    else
        throw e;
}