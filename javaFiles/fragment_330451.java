Highlighter.HighlightPainter painter = 
    new DefaultHighlighter.DefaultHighlightPainter( Color.cyan );

int offset = text.indexOf(searchWord);
int length = searchWord.length();

while ( offset != -1)
{
    try
    {
        textPane.getHighlighter().addHighlight(offset, offset + length, painter);
        offset = text.indexOf(searchWord, offset+1);
    }
    catch(BadLocationException ble) { System.out.println(ble); }
}