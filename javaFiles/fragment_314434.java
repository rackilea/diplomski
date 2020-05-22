void Condition() : {}{
        <NOT> Condition()
    |   LOOKAHEAD( <OPEN_PARENTHESIS> )
        (
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
        )
    |
        Expression()
        CompOp()
        Expression()   
}