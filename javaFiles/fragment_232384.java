AttributedCharacterIterator aci1 = attributedString1.getIterator();
AttributedCharacterIterator aci2 = attributedString2.getIterator();

StringBuilder sb = new StringBuilder();

char ch = aci1.current();
while( ch != CharacterIterator.DONE)
{
    sb.append( ch);
    ch = aci1.next();
}

ch = aci2.current();
while( ch != CharacterIterator.DONE)
{
    sb.append( ch);
    ch = aci2.next();
}

AttributedString combined = new AttributedString( sb.toString());
combined.addAttributes( aci1.getAttributes(), 0, aci1.getEndIndex());
combined.addAttributes( aci2.getAttributes(), aci1.getEndIndex(), aci1.getEndIndex() + aci2.getEndIndex());