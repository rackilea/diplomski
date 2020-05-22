public class LoggingErrorHandler implements ErrorHandler {

    private boolean isValid = true;

    public boolean isValid() {
        return this.isValid;
    }

    @Override
    public void warning(SAXParseException exc) {
        System.err.println(exc);
    }

    @Override
    public void error(SAXParseException exc) {
        System.err.println(exc);
        this.isValid = false;
    }

    @Override
    public void fatalError(SAXParseException exc) throws SAXParseException {
        System.err.println(exc);
        this.isValid = false;
        throw exc;
    }
}