void Nonterminal() : {}
{
    LOOKAHEAD( <TOKEN> <COLON> A() <COMMA>)
    <TOKEN> <COLON> A() <COMMA> Nonterminal()
|
    <TOKEN> <COLON> A()
}