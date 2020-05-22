\u002f\u002a <- multi line comment start
multi
line
comment // not a single line comment
\u002A/
public class Test {

  // single line "not a string"

  String s = "\u005C" \242 not // a comment \\\" \u002f \u005C\u005C \u0022;
  /*
  regular multi line comment
  */
  char c = \u0027"'; // the " is not the start of a string

  char q1 = '\u005c'';                  // == '\''
  char q2 = '\u005c\u0027';             // == '\''
  char q3 = \u0027\u005c\u0027\u0027;   // == '\''
  char c4 = '\047';

  String t = "/*";
  \u002f\u002f another single line comment
  String u = "*/";
}