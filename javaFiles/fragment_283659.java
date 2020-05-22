public class BookService {

      @Filter("title ~ 'Monkey'") //example custom annotation
      public List<Book> findBooks(...) { /*get books from the DB */ }
}

new SimpleInstrumentation() {

    // You can also use beginFieldFetch and then onCompleted instead of instrumentDataFetcher
    @Override
    public DataFetcher<?> instrumentDataFetcher(DataFetcher<?> dataFetcher, InstrumentationFieldFetchParameters parameters) {
        GraphQLFieldDefinition field = parameters.getEnvironment().getFieldDefinition();
        Optional<String> filterExpression = Directives.getMappedOperation(field)
                .map(operation ->
                        operation.getApplicableResolver(parameters.getEnvironment().getArguments().keySet())
                                .getExecutable().getDelegate()
                                .getAnnotation(Filter.class).value()); //get the filtering expression from the annotation
        return filterExpression.isPresent() ? env -> filterResultBasedOn Expression(dataFetcher.get(parameters.getEnvironment()), filterExpression) : dataFetcher;
    }
}