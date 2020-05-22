"(?im)" +       // Match the remainder of the regex with the options: case insensitive (i); ^ and $ match at line breaks (m)
"^" +           // Assert position at the beginning of a line (at beginning of the string or after a line break character)
"." +           // Match any single character that is not a line break character
   "*?" +          // Between zero and unlimited times, as few times as possible, expanding as needed (lazy)
"(?<!" +        // Assert that it is impossible to match the regex below with the match ending at this position (negative lookbehind)
   "-" +           // Match the character “-” literally
")" +
"toto\\ win" +   // Match the characters “toto win” literally
"\\b" +          // Assert position at a word boundary
"." +           // Match any single character that is not a line break character
   "*" +           // Between zero and unlimited times, as many times as possible, giving back as needed (greedy)
"$"             // Assert position at the end of a line (at the end of the string or before a line break character)