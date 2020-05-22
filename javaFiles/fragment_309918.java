public static void main(final String[] args) {
    final JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    f.setTitle("JEditorPane Test");

    final String text = "<html><body><a name='link1'>test</a>some text<br /><a href='#thisisbottom'>down</a><br /><br /><br /><br /><br /><br /><br /><br /><br /><a name='mid1'></a>some more text<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />some more text [<a href='#link1'>jump to top</a>] <br /> or jump to <a name='thisisbottom' href='#mid1'>center</a></body></html>";

    final JEditorPane ep = new JEditorPane();
    ep.setContentType("text/html");
    ep.setText(text);
    ep.setEditable(false);
    ep.addHyperlinkListener(new HyperlinkListener() {
        @Override public void hyperlinkUpdate(final HyperlinkEvent pE) {
            if (HyperlinkEvent.EventType.ACTIVATED == pE.getEventType()) {
                System.out.println("JEditorPane link click: url='" + pE.getURL() + "' description='" + pE.getDescription() + "'");
                String reference = pE.getDescription();
                if (reference != null && reference.startsWith("#")) { // link must start with # to be internal reference
                    reference = reference.substring(1);
                    ep.scrollToReference(reference);
                }
            }
        }
    });

    final JScrollPane sp = new JScrollPane(ep);
    f.add(sp);

    f.setBounds(200, 200, 400, 400);
    f.setVisible(true);
}