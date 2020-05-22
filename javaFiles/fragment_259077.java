entrypoints Config;

comment "#";
rules MyBoolean ::= "True" | "False";
Conf. Config ::= [Section];  -- a config is a list of sections
terminator Section "";

Sec. Section ::= "[" NomeSec "]" [Decl]; -- A section is made of a name and a list of declarations
terminator Decl ";";

NomeSez. NomeSec ::= Ident;

Dec. Decl ::= VarN "=" Type;

VarName. VarN ::= Ident;

TInt.    Type::=Integer;
TChar.   Type::=Char;
TString. Type::=String;
TFloat.  Type::=Double;
TBool.   Type::=MyBoolean;