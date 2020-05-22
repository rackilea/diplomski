"(?im)" +         // Match the remainder of the regex with the options: case insensitive (i); ^ and $ match at line breaks (m)
"^" +             // Assert position at the beginning of a line (at beginning of the string or after a line break character)
"[?.\\s%a-z]" +    // Match a single character present in the list below
                     // One of the characters “?.”
                     // A whitespace character (spaces, tabs, and line breaks)
                     // The character “%”
                     // A character in the range between “a” and “z”
   "*?" +            // Between zero and unlimited times, as few times as possible, expanding as needed (lazy)
"\\b" +            // Assert position at a word boundary
"toto\\ win" +     // Match the characters “toto win” literally
"\\b" +            // Assert position at a word boundary
"." +             // Match any single character that is not a line break character
   "+" +             // Between one and unlimited times, as many times as possible, giving back as needed (greedy)
"$"               // Assert position at the end of a line (at the end of the string or before a line break character)