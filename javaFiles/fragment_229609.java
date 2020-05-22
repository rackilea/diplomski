class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {
        public MyHighlightPainter(Color color) {
            super(color);
        }   

    Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.yellow);

    public void highlightt(JTextArea textComp, String pattern) {
        try {
            Highlighter hilite = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            while((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0) {

                hilite.addHighlight(pos, pos+pattern.length(), myHighlightPainter);
                pos +=pattern.length();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }   
    }

} // close class