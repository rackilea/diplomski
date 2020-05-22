/**
 * A method available to subclasses for adding default
 * {@link HandlerExceptionResolver HandlerExceptionResolvers}.
 * <p>Adds the following exception resolvers:
 * <ul>
 * <li>{@link ExceptionHandlerExceptionResolver} for handling exceptions through
 * {@link org.springframework.web.bind.annotation.ExceptionHandler} methods.
 * <li>{@link ResponseStatusExceptionResolver} for exceptions annotated with
 * {@link org.springframework.web.bind.annotation.ResponseStatus}.
 * <li>{@link DefaultHandlerExceptionResolver} for resolving known Spring exception types
 * </ul>
 */
protected final void addDefaultHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers,
        ContentNegotiationManager mvcContentNegotiationManager) {