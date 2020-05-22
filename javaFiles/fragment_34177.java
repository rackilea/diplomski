void NonTerminal #void : { Token t;}
{
    t = <MULTIPLY>
    OtherNonTerminal() {jjtThis.value = t.image;} 
    #Multiply(2)
}