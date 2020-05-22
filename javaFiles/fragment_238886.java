//...
public void quoteRecieved(SimpleChannelInboundHandler source, final String quote) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            text.setText(packet);
        }
    });
}