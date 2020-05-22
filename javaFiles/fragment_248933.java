final JTextPane textPane = new JTextPane();
    textPane.setEditable(false);
    textPane.setContentType("text/html");
    textPane.setText("File not found please contact:<a href='mailto:michael@uml.com'>e-mail to</a> or call 9639");
    textPane.addHyperlinkListener(new HyperlinkListener() {
        @Override
        public void hyperlinkUpdate(HyperlinkEvent e) {
            if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                System.out.println(e.getURL());
                // write your logic here to process mailTo link.
            }
        }
    });