/**
 * Method that will parse actual numeric value out of a syntactically
 * valid number value. Type it will parse into depends on whether
 * it is a floating point number, as well as its magnitude: smallest
 * legal type (of ones available) is used for efficiency.
 *
 * @param expType Numeric type that we will immediately need, if any;
 *   mostly necessary to optimize handling of floating point numbers
 */
protected void _parseNumericValue(int expType) throws IOException
{
    // Int or float?
    if (_currToken == JsonToken.VALUE_NUMBER_INT) {
        int len = _intLength;
        // First: optimization for simple int
        if (len <= 9) { 
            int i = _textBuffer.contentsAsInt(_numberNegative);
            _numberInt = i;
            _numTypesValid = NR_INT;
            return;
        }
        if (len <= 18) { // definitely fits AND is easy to parse using 2 int parse calls
            long l = _textBuffer.contentsAsLong(_numberNegative);
            // Might still fit in int, need to check
            if (len == 10) {
                if (_numberNegative) {
                    if (l >= MIN_INT_L) {
                        _numberInt = (int) l;
                        _numTypesValid = NR_INT;
                        return;
                    }
                } else {
                    if (l <= MAX_INT_L) {
                        _numberInt = (int) l;
                        _numTypesValid = NR_INT;
                        return;
                    }
                }
            }
            _numberLong = l;
            _numTypesValid = NR_LONG;
            return;
        }
        _parseSlowInt(expType);
        return;
    }
    if (_currToken == JsonToken.VALUE_NUMBER_FLOAT) {
        _parseSlowFloat(expType);
        return;
    }
    _reportError("Current token (%s) not numeric, can not use numeric value accessors", _currToken);
}