Pattern regex = Pattern.compile(
    "^             # Start of string                 \n" +
    "(?!.{65})     # Assert length not 65 or greater \n" +
    "(?:           # Match either                    \n" +
    " 0            #  0                              \n" +
    "|             # or                              \n" +
    " [1-9]\\d*    #  1-n, no leading zeroes         \n" +
    ")             # End of alternation              \n" +
    "(?:           # Match...                        \n" +
    " \\.          #  a dot                          \n" +
    " \\d{2}       #  followed by exactly 2 digits   \n" +
    ")?            # ...optionally                   \n" +
    "$             # End of string", 
    Pattern.COMMENTS);