public static final class ConvertBodyToStringProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception { // NOPMD
        new ConvertBodyProcessor(String.class, (String) new HeaderExpression(Exchange.HTTP_CHARACTER_ENCODING).evaluate(exchange)).process(exchange);
    }
}