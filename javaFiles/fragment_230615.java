grammar T;

parse returns [java.util.Map<String, List<Integer>> map]
@init{$map = new java.util.HashMap<String, List<Integer>>();}
 : (line {$map.put($line.key, $line.values);} )+ EOF
 ;

line returns [String key, List<Integer> values]
 : Id numbers (NL | EOF)
   {
     $key = $Id.text;
     $values = $numbers.list;
   }
 ;

numbers returns [List<Integer> list]
@init{$list = new ArrayList<Integer>();}
 : (Num {$list.add(Integer.parseInt($Num.text));} )+
 ;

Num   : '0'..'9'+;
Id    : ('a'..'z' | 'A'..'Z')+;
NL    : '\r'? '\n' | '\r';
Space : (' ' | '\t')+ {skip();};