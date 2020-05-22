Model:
    (classes+=Class)*
    (fields+=Field)*;

PrimitiveType: 'String' | 'Number' | 'Boolean';

Field:
    PrimitiveField | ObjectField
;

PrimitiveField:
    type=PrimitiveType name=ID ";"
;
ObjectField:
    type=[Class] name=ID ";";

Class:
    "class" name=ID
    "{"
    (fields+=Field)*
    (methods+=Method)*
    "}";