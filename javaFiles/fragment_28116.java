Highlighter highlighter = jtextArea.getHighlighter();
    DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.blue);
int front=0;

public void highligtNextWord(JTextArea ta)throws Exception{
    String str=ta.getText().trim()+" ";
    int end=str.indexOf(" ",front);
    highlighter.removeAllHighlights();
    highlighter.addHighlight(front, end, painter);
    if(end>=str.length()-1)
        front=0;
    else
        front=end+1;
}