/* <- multi line comment start
multi
line
comment // not a single line comment
*/
public class Test2 {

  // single line "not a string"

  String s = "\" \242 not // a comment \\\" ";
  /*
  regular multi line comment
  */
  char c = '"'; // the " is not the start of a string

  char q1 = '\'';                  // == '\''
  char c4 = '\047';

  String t = "/*";
  // another single line comment
  String u = "*/";
}