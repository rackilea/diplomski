void NonTerminal() #Nonterminal(2) : {
    Token t; }
{
    ( t = <MULTIPLY> OtherNonTerminal()
    | t = <DIVIDE> OtherNonTerminal()
    | {}
    )
    {jjtThis.value = t.image;}
}