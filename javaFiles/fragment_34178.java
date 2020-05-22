void NonTerminal() #void : { Token t; }
{
    t = <MULTIPLY>
    OtherNonTerminal()
    { jjtThis.value = t.image; }
    #Mult(2)
|
    t = <DIVIDE>
    OtherNonTerminal()
    { jjtThis.value = t.image; }
    #Div(2)
|
    {}
}