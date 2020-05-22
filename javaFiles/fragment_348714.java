while((value = reader.read()) != -1)
{
     // Convert int to a character
     char c = (char)value;
     strb.append(c);
}
String str = strb.toString();