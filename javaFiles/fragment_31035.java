//Let's set a RowProcessorErrorHandler to log the error. The parser will keep running.
    settings.setProcessorErrorHandler(new RowProcessorErrorHandler() {
        @Override
        public void handleError(DataProcessingException error, Object[] inputRow, ParsingContext context) {
            println(out, "Error processing row: " + Arrays.toString(inputRow));
            println(out, "Error details: column '" + error.getColumnName() + "' (index " + error.getColumnIndex() + ") has value '" + inputRow[error.getColumnIndex()] + "'");
        }
    });