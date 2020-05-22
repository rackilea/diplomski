private StringBuffer tempValue = new StringBuffer();

startElement()
{
    tempValue.setLength(0); // clear buffer...
}

characters(characters(char[] ch, int start, int length)
{
    tempValue.append(ch, start, length); // append to buffer
}

endElement()
{
    String value = tempValue.toString(); // use characters in buffer...
}