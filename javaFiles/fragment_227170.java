MultiLineComment  :: \u002f\u002a <- multi line comment start\nmulti\nline\ncomment // not a single line comment\n\u002A/
SingleLineComment :: // single line "not a string"
SingleLineComment :: // a comment \\\" \u002f \u005C\u005C \u0022;
MultiLineComment  :: /*\n  regular multi line comment\n  */
SingleLineComment :: // the " is not the start of a string
SingleLineComment :: // == '\''
SingleLineComment :: // == '\''
SingleLineComment :: // == '\''
SingleLineComment :: \u002f\u002f another single line comment