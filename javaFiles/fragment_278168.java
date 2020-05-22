public static int parseInt(String s) throws NumberFormatException {
         return parseInt(s,10);
    }

    public static int parseInt(String s, int radix) throws NumberFormatException
    {
        if (s == null) {
            throw new NumberFormatException("null");
        }

    if (radix < Character.MIN_RADIX) {
        throw new NumberFormatException("radix " + radix +
                        " less than Character.MIN_RADIX");
    }

    if (radix > Character.MAX_RADIX) {
        throw new NumberFormatException("radix " + radix +
                        " greater than Character.MAX_RADIX");
    }

    int result = 0;
    boolean negative = false;
    int i = 0, max = s.length();
    int limit;
    int multmin;
    int digit;

    if (max > 0) {
        if (s.charAt(0) == '-') {
        negative = true;
        limit = Integer.MIN_VALUE;
        i++;
        } else {
        limit = -Integer.MAX_VALUE;
        }
        multmin = limit / radix;
        if (i < max) {
        digit = Character.digit(s.charAt(i++),radix);
        if (digit < 0) {
            throw NumberFormatException.forInputString(s);
        } else {
            result = -digit;
        }
        }
        while (i < max) {
        // Accumulating negatively avoids surprises near MAX_VALUE
        digit = Character.digit(s.charAt(i++),radix);
        if (digit < 0) {
            throw NumberFormatException.forInputString(s);
        }
        if (result < multmin) {
            throw NumberFormatException.forInputString(s);
        }
        result *= radix;
        if (result < limit + digit) {
            throw NumberFormatException.forInputString(s);
        }
        result -= digit;
        }
    } else {
        throw NumberFormatException.forInputString(s);
    }
    if (negative) {
        if (i > 1) {
        return result;
        } else {    /* Only got "-" */
        throw NumberFormatException.forInputString(s);
        }
    } else {
        return -result;
    }
    }