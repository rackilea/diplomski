grammar PersonNamesMinimal;

// just parse zero or more tokens (no matter what) and print their type and text
parse
  :  (t=. {System.out.printf("\%-25s \%s\n", tokenNames[$t.type], $t.text);})* EOF
  ;


LNAME_PREFIX : (V O N | V A N ' ' D E R | V A N ' ' D E N | V A N | D E ' ' L A | D E | B I N) ' ';
O_APOS       : ('O'|'o') '\'';
NAME         : (O_APOS? LETTER LETTER+) | LETTER;
INITIAL      : LETTER '.';
AND          : ( ' '+ A N D ' '+ ) | (' '* '&' ' '*);
COMMA        : ',';

fragment LETTER : 'A' .. 'Z' | 'a' .. 'z';

fragment A : 'A' | 'a';
fragment B : 'B' | 'b';
fragment C : 'C' | 'c';
fragment D : 'D' | 'd';
fragment E : 'E' | 'e';
fragment F : 'F' | 'f';
fragment G : 'G' | 'g';
fragment H : 'H' | 'h';
fragment I : 'I' | 'i';
fragment J : 'J' | 'j';
fragment K : 'K' | 'k';
fragment L : 'L' | 'l';
fragment M : 'M' | 'm';
fragment N : 'N' | 'n';
fragment O : 'O' | 'o';
fragment P : 'P' | 'p';
fragment Q : 'Q' | 'q';
fragment R : 'R' | 'r';
fragment S : 'S' | 's';
fragment T : 'T' | 't';
fragment U : 'U' | 'u';
fragment V : 'V' | 'v';
fragment W : 'W' | 'w';
fragment X : 'X' | 'x';
fragment Y : 'Y' | 'y';
fragment Z : 'Z' | 'z';

SPACE : ' ';