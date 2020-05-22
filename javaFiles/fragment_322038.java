grammar T;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  STATS;
  DISPLAYED_COLUMN;
  NAME;
  SELECT;
}

@parser::header {
  import java.util.Map;
  import java.util.HashMap;
}

@parser::members {
  private Map<String, CommonTree> aliases = new HashMap<String, CommonTree>();
}

parse
 : (stmt ';')+ EOF -> ^(STATS stmt+)
 ;

stmt
 : set_stmt
 | select_stmt
 ;

set_stmt
 : 'set' 'alias' name Id {aliases.put($Id.text, $name.tree);} -> /* AST can be omitted */
 ;

select_stmt
 : 'select' displayed_column 'from' name -> ^(SELECT displayed_column name)
 ;

displayed_column
 : sql_expression -> {aliases.containsKey($text)}? ^(DISPLAYED_COLUMN {aliases.get($text)})
                  ->                               ^(DISPLAYED_COLUMN sql_expression)
 ;

sql_expression
 : term (('+' | '-')^ term)*
 ;

term
 : factor (('*' | '/')^ factor)*
 ;

factor
 : Num
 | name
 | '(' sql_expression ')'
 ;

name
 : Id ('.' Id)* -> ^(NAME Id+)
 ;

Id    : 'a'..'z'+;
Num   : '0'..'9'+;
Space : (' ' | '\t' | '\r' | '\n')+ {skip();};