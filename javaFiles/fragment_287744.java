class ParserManager {
    ...
    Properties props;

    public void setParsingProperties(Properties props) {
        this.props = props;
    }

    public void parse(String message) {
        // props available here, without being passed as agurment.
    }
}

class CallingParserManager {
    ...
    void someMethod() {
        ...
        parserManager.setParsingProperties(propertiesToUse);
        parserManager.parse(theString);
        ...
    }
    ...
}