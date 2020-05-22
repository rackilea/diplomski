private void addImage(final String image){
    imagePanel.addImage(image);
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            final JScrollBar vScroll = imageScrollPane.getVerticalScrollBar();
            vScroll.setValue(vScroll.getMaximum());
        }
    });
}