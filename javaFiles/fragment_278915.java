// you need java.util.regex.Pattern and java.text.DecimalFormatSymbols
string ds = Pattern.quote(DecimalFormatSymbols.getDecimalSeparator())
string gs = Pattern.quote(DecimalFormatSymbols.getGroupingSeparator())
string ms = Pattern.quote(DecimalFormatSymbols.getMinusSign())
string es = Pattern.quote(DecimalFormatSymbols.getExponentSeparator())

string myre = 
    "(?xi)\n       # verbose, case-insensitive regex" +
    "[+" +ms+ "]?  # optional sign\n" +
    "(?:           # required significand: either...\n" +
    " (?:\\d{1,3}(?:" +gs+ "\\d{3}|\\d++) # a number with optional thousand separators,\n" +
    " (?:" +ds+ "\\d*)? # optionally followed by a dot, optionally followed by more digits\n" +
    " |            # or...\n" +
      ds+ "\\d+    # just a dot, followed by digits (in this case required)\n" +
    ")             # end of significand\n" +
    "(?:           # optional exponent\n" +
      es+ "        # required exponent indicator\n" +
    " [+" +ms+ "]? # optional sign\n" +
    " \\d+         # required digits\n" +
    ")?            # end of exponent"

boolean foundMatch = subjectString.matches(myregex);