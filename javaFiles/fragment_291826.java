String[] arr = str.split("(?x)   " + 
                     ",          " +   // Split on comma
                     "(?=        " +   // Followed by
                     "  (?:      " +   // Start a non-capture group
                     "    [^\"]* " +   // 0 or more non-quote characters
                     "    \"     " +   // 1 quote
                     "    [^\"]* " +   // 0 or more non-quote characters
                     "    \"     " +   // 1 quote
                     "  )*       " +   // 0 or more repetition of non-capture group (multiple of 2 quotes will be even)
                     "  [^\"]*   " +   // Finally 0 or more non-quotes
                     "  $        " +   // Till the end  (This is necessary, else every comma will satisfy the condition)
                     ")          "     // End look-ahead
                         );