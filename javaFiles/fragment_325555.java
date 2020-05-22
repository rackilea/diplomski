int row = 0;

while ((String textLine = bf.readLine()) != null) 
{
    String text = textLine.split("    ");

    for (int i = 0; i < text.length; i++)
    {
         data[row][i] = text[i];
    }

    row++
}