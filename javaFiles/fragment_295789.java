public void CommonTokenAction(Token t)
{
    int c = getCurrentTokenAbsolutePosition() + t.image.length();
    do {
        t.absoluteEndColumn = c ;
        c -= t.image.length() ;
        t.absoluteBeginColumn = c;
        t = t.specialToken ;
    } while( t != null ) ;
}