void Nonterminal() : {}
{
    <TOKEN> <COLON> A()
|
    <TOKEN> <COLON> A() <COMMA> Nonterminal()
}