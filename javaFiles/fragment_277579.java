private static CharSequenceTranslator translatorIgnoringLineSeparators = 
    new LookupTranslator(
        new String[][] { 
                { "\"", "\\\"" }, 
                { "\\", "\\\\" }, 
        }).with(
                new LookupTranslator(new String[][] {
                        { "\b", "\\b" },
                        { "\n", "\n"  },//this will handle `\n` and will not change it
                        { "\r", "\r"  },//this will handle `\r` and will not change it
                        { "\t", "\\t" }, 
                        { "\f", "\\f" },
        })).with(UnicodeEscaper.outsideOf(32, 0x7f));

public static String myJavaEscaper(CharSequence input) {
    return translatorIgnoringLineSeparators.translate(input);
}