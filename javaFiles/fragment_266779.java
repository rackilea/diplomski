public SinglePlayerMenu() {
    super();
    this.addComponentListener( new ComponentAdapter() {
        @Override
        public void componentShown( ComponentEvent e ) {
            SinglePlayerMenu.this.requestFocusInWindow();
        }
    });
}