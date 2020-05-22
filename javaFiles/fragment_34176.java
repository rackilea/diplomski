void NonTerminal #Nonterminal: { Token t;}
{
    t = <MULTIPLY>
    OtherNonTerminal() {jjtThis.value = t.image;}
    #Multiply
}