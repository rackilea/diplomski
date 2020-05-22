program returns [Program value]
    : PROGRAM d=zeroOrMoreDecl s=oneOrMoreStmt END {$value = new Program($d.value, $s.value);}
    ;

zeroOrMoreDecl returns [ArrayList<Declaration> value]
    : {$value = new ArrayList<Declaration>();} (d=decl {$value.add($d.value);})*
    ;

decl returns [Declaration value]
    : ...