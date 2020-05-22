grammar SmallTest;

@header {
package parseTest;
import java.util.ArrayList;
}

@lexer::header {
package parseTest;
}

prog returns [ArrayList<ArrayList<String>> all]
@init {$all = new ArrayList<ArrayList<String>>();}
  :  (stat {$all.add($stat.res);})+ EOF
  ;

stat returns [ArrayList<String> res]
@init {$res = new ArrayList<String>();}
  :  (ELEMENT {$res.add($ELEMENT.text);})* NEWLINE
  ;

ELEMENT : ('a'..'z'|'A'..'Z')+ ;
NEWLINE : '\r'? '\n' ;
SPACE   : ' ' {skip();};