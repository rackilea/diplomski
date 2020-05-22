public void actionPerformed(ActionEvent e)
{
  try {
    Highlighter highlighter = area.getHighlighter();
    HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
    highlighter.addHighlight(0 , 6, painter);
  catch(throws BadLocationException ex) {
    ex.printStackTrace();
  }
}