void Assign() : { Token var; int value;}
{
    var = <TK_ID>
    <TK_EQ> 
    value = Exp()

    {
        TableVariables.assignValue(var,value);
    }
}