// create formatter, no need of strict mode
DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
// parse
ParsePosition pos = new ParsePosition(0);
TemporalAccessor parsed = fmt.parseUnresolved(valueWithDate, pos);
// check errors
if (pos.getErrorIndex() >= 0) {
    // error in parsing (getErrorIndex() returns the index where the error occurred)
}
// rest of the code is the same