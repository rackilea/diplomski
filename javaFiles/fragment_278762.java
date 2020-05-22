VariableDeclaration:
    modifiers+=Modifier* type=Type name=ID ('=' value=VariableValue)? ';';

VariableValue:
    TypedLiteral | VariableReference;

TypedLiteral:
    IntegerLiteral | ...;

IntegerLiteral:
    value=INTVAL;

terminal INTVAL returns ecore::ELong:
    (Plus|Minus)? INT;

VariableReference:
    ref=[VariableDeclaration|QualifiedName];