public class ExceptionHandler implements DataFetcherExceptionHandler {

    @Override
    public DataFetcherExceptionHandlerResult onException(DataFetcherExceptionHandlerParameters handlerParameters) {

    Throwable exception = handlerParameters.getException();

    // do something with exception

    GraphQLError error = GraphqlErrorBuilder
            .newError()
            .message(exception.getMessage())
            .build();

    return DataFetcherExceptionHandlerResult
            .newResult()
            .error(error)
            .build();
    }
}