public enum Actions {
    COPY( new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            //do something
        }
    }),
    PASTE( new PasteAction() );

    public final AbstractAction action;
    private Actions(AbstractAction action) {
        this.action = action;
    }

}

//...
Actions.COPY.action...;