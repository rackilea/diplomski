public class AllExceptHeaderQuoteMode implements QuoteMode {

    @Override
    public boolean quotesRequired(String csvColumn, CsvContext context, CsvPreference preference) {
        if (1 == context.getLineNumber()) {
            /*
             * Case whene column names are written
             */
            return false;
        } else {
            return true;
        }
    }
}