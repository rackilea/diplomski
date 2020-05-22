final Shell shell = new Shell();

final GridLayout layout = new GridLayout( 3, true );
shell.setLayout( layout );

shell.addControlListener( new ControlAdapter() {
    @Override
    public void controlResized( ControlEvent event ) {
        int newColumnNumber = 5; // Calculate your new value here.
        layout.numColumns = newColumnNumber;
        shell.layout( true );
    }
} );