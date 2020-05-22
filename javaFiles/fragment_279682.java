JEditorPane content = new JEditorPane();
    content.setContentType("text/html");
    content.setEditable(false);
    content.setText("<html><a href=\"http://stackoverflow.com\">Link</a></html>"));
    content.addHyperlinkListener(new HyperlinkListener() {
        @Override
        public void hyperlinkUpdate(HyperlinkEvent e) {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    Desktop.getDesktop().browse(e.getURL().toURI());
                } catch (Exception e1) {
                    Logger.getLogger(getClass()).error(
                            "Error opening link " + e.getURL(), e1);
                }
            }
        }
    });