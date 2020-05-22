while( ( c = is.read() ) != -1 )
{ 
    if(prev == '\r' && c == '\n')
    {
        break;
    }
    text = text + (char) c;  
    prev = (char) c;
}