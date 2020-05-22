void CompOp() : {} { <EQUAL_CHECK> | <NOT_EQUAL> | <LESS> | <LESS_EQUAL> | <GREATER> | <GREATER_EQUAL> }

void Condition() : {}{
        <NOT> Condition()
    |
        LOOKAHEAD(Expression() CompOp()) 
        Expression()
        CompOp()
        Expression()   
    |
        <OPEN_PARENTHESIS>
        Condition()
        (<AND> | <OR>)
        Condition()
        <CLOSE_PARENTHESIS>
}