JTextPane editor = new JTextPane();
editor.setContentType("text/html");
editor.setText("<html><body><table><tr><td><a href=\"a1\" >Cell1</a></td><td><a href=\"a2\">Cell2</a></td></tr></table></body></html>");
editor.addHyperlinkListener(new HyperlinkListener(){

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if ( e.getEventType() == HyperlinkEvent.EventType.ACTIVATED ){
            System.out.println(e.getDescription());
        }

    }

});
editor.setEditable(false);