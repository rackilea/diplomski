Pattern p = Pattern.compile(
    "(?:"       + // Open a "non-capturing" group for our two letter sequences
    "ABCD"      + // The sequence ABCD ...
    "|"         + // OR ...
    "HIJK"      + // the sequence HIJK
    ")"         + // close the group
    "\\d"       + // A digit ...
    "{4}"       + // exactly 4 times
    "_"         + // an underscore
    ".*"          // Anything else.
);

assertTrue(p.matcher("ABCD9403_XXXXXXXXXXXX.XXX").matches());
assertTrue(p.matcher("HIJK6701_xXxXxX.xXx").matches());
assertFalse(p.matcher("AMCD6987_xxxxxx.xxx").matches());
assertFalse(p.matcher("HIJK12F2_xxxxxxx.xxx").matches());
assertFalse(p.matcher("ABCD9547-21654sdasd321.321asd").matches());