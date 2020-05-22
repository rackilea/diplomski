public class ExceptionHandler {
    // simple internal manager
    @FunctionalInterface
    private interface ExceptionManager<D extends Exception> {
        int getErrorCode(D e, WebRequest request, HttpServletRequest servletRequest);
    }
    // One field, just for the illustration 
    private static ExceptionManager<TypeMismatchException> tmeManager = 
       (ex, req, servletRequest) -> {
          int errorCode = 0;
          // ...
          return errorCode;
       };

    // A simple "factory" for an ExceptionManager
    private static <E extends Exception> Optional<ExceptionManager<E>> factory(E ex) {
        if(ex instanceof TypeMismatchException) {
            // unavoidable unchecked operation
            @SuppressWarnings("unchecked") ExceptionManager<E> em
                                         = (ExceptionManager<E>)tmeManager;
            return Optional.of(em);
        }
        /* ... */
        return Optional.empty();
    }
    // global  exception manager
    private ExceptionManager<Exception> defaultExceptionManager
                                      = ExceptionHandler::handleDefault;

    static <E extends Exception> int handleDefault(E exception, WebRequest request, 
                                                   HttpServletRequest servletRequest) {
        final Optional<ExceptionManager<E>> manager = factory(exception);
        return manager.map(em -> em.getErrorCode(exception, request, servletRequest))
                      .orElse(1);
    }
}