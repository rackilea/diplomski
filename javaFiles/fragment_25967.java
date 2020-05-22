class ErrorCollector implements ErrorListener {

    private List<TransformerException> errors = new ArrayList<TransformerException>();

    @Override
    public void error(TransformerException exception) throws TransformerException {
        errors.add(exception);
    }

    ...
}