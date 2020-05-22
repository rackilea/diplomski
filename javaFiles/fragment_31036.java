settings.setProcessorErrorHandler(new RetryableErrorHandler<ParsingContext>() {
    @Override
    public void handleError(DataProcessingException error, Object[] inputRow, ParsingContext context) {
        //if there's an error in the first column, assign 50 and proceed with the record.
        if(error.getColumnIndex() == 0){ 
            setDefaultValue(50);
        } else { //else keep the record anyway. Null will be used instead.
            keepRecord();
        }
    }
});