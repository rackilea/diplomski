Vector data = new Vector();

while ((String textLine = bf.readLine()) != null) 
{
    String text = textLine.split("    ");
    Vector row = new Vector();

    for (int i = 0; i < text.length; i++)
    {
         row.addElement( text[i] );
    }
}