object -> { members }    // each object replaces by { members }
members  -> pair      // each  members  replaces by pair
pair ->  string : value  // and so on ...
string -> "chars"
" chars " -> char chars
char -> any-Unicode-character-
        except-"-or-\-or-
        control-character  \"  \\  \/  \b \f \n \r \t \u four-hex-digits