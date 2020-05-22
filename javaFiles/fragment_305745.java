SourceFile:
    (statements+=TopLevelStatement)*
;

TopLevelStatement:
    Declaration
;

Declaration:
    StructDeclaration|ClassDeclaration
;

StructDeclaration:
    'struct' name=Identifier '{' '}' ';'?
;

ClassDeclaration:
    'class' name=Identifier '{' '}' ';'?
;

Identifier:
    ID
;