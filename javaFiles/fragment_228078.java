public static void main(String[] args)  {

    JTextPane t = new JTextPane();
    t.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    Highlighter hilite = new MyHighlighter();
    t.setHighlighter(hilite);
    t.setText("Line1\nLine2\nLine3\nLine4\nLine5\n");


    DefaultHighlightPainter whitePainter = new DefaultHighlighter.DefaultHighlightPainter(Color.WHITE);
    DefaultHighlightPainter grayPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GRAY);

    try {
        Document doc = t.getDocument();
        String text = doc.getText(0, doc.getLength());
        int start = 0;
        int end = 0 ;

        boolean even = true;

        //look for newline char, and then toggle between white and gray painters.
        while ((end = text.indexOf('\n', start)) >= 0) {
            even = !even;
            DefaultHighlightPainter painter = even ? grayPainter : whitePainter;
            hilite.addHighlight(start, end+1, painter);
            start = end+1;
        }
    } catch (BadLocationException e) {
        e.printStackTrace();
    }

    JPanel p = new JPanel(new BorderLayout());      
    p.add(t, BorderLayout.CENTER);
    JFrame f = new JFrame();
    f.add(p);
    f.setSize(100, 100);
    f.setVisible(true);
}