try {
    ...
    xmlReader.parse();
} catch (SAXException e) {
    if (e.Cause instanceof BreakParsingException) {
        // we have broken the parsing process
        ....
    }
}