String[] ww = input.split("\\s+" +             // consume white space
     "|(?:" +                                  // start non-capture
         "(?<=[^a-zA-Z0-9 ])" +                // look behind non alphanumeric & white space
         "|(?=[^a-zA-Z0-9 ])" +                // look ahead non alphanumeric & white space
         "|((?=[0-9])(?<![0-9 ]))" +           // ahead is number, behind is letter 
         "|((?=[a-zA-Z])(?<![a-zA-Z ]))" +     // ahead is letter, behind is number
     ")");