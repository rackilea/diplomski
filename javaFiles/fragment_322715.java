public void writeCharacters(char[] text, int start, int len) 
    throws XMLStreamException
{
    w.writeCharacters(text, start, len);
}

// All this code just to override this method
public void writeCharacters(String text) throws XMLStreamException
{

    w.writeCData(text);
}