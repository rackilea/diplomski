grammar T;  

parse
 : ids {System.out.println($ids.firstId + "\n" + $ids.allIds);}
 ;

ids returns [String firstId, List<String> allIds]
@init{$allIds = new ArrayList<String>();}
@after{$firstId = $allIds.get(0);}
 : (ID {$allIds.add($ID.text);})+
 ;

ID    : ('a'..'z' | 'A'..'Z')+;
SPACE : ' ' {skip();};