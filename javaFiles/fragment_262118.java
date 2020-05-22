@Override
public T mapLine(String line, int lineNumber) throws Exception {
    T t = null;

    try {
        t = super.mapLine(line, lineNumber);
    } catch (Exception e) {
        log.error("Unable to parse line number <<{}>> with line <<{}>>.", lineNumber, line);
    }

    return t;
}