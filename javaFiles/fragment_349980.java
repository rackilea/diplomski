STRING      
@init{StringBuilder lBuf = new StringBuilder();}
    :   
           '"' 
           ( escaped=ESC {lBuf.append(getText());} | 
             normal=~('"'|'\\'|'\n'|'\r')     {lBuf.appendCodePoint(normal);} )* 
           '"'     
           {setText(lBuf.toString());}
    ;

fragment
ESC
    :   '\\'
        (   'n'    {setText("\n");}
        |   'r'    {setText("\r");}
        |   't'    {setText("\t");}
        |   'b'    {setText("\b");}
        |   'f'    {setText("\f");}
        |   '"'    {setText("\"");}
        |   '\''   {setText("\'");}
        |   '/'    {setText("/");}
        |   '\\'   {setText("\\");}
        |   ('u')+ i=HEX_DIGIT j=HEX_DIGIT k=HEX_DIGIT l=HEX_DIGIT
                   {setText(ParserUtil.hexToChar(i.getText(),j.getText(),
                                                 k.getText(),l.getText()));}

        )
    ;