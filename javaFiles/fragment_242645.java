<PRE_REFERENCE,REFMODIFIER,REFMOD2>
TOKEN :
{
    <#ALPHA_CHAR: ["a"-"z", "A"-"Z", "_"] >
|   <#IDENTIFIER_CHAR: [ "a"-"z", "A"-"Z", "0"-"9", "_" ] >
|   <IDENTIFIER:  ( <ALPHA_CHAR> ) (<IDENTIFIER_CHAR>)* >
    {
        if (curLexState == PRE_REFERENCE)
        {
            SwitchTo(REFERENCE);
        }
    }
}