public class StackPanel extends JPanel {

    CardLayout layout = new CardLayout();
    public StackPanel() {
        super();
        setLayout( layout );
    }

    public addStack( String name, JComponent child ) {
        add( name, child );
    }

    public void showStack( String name ) {
        layout.show( this, name );
    }
}


CardLayout layout = new CardLayout();
StackPanel stack = new StackPanel();
stack.addStack( "panelOne", panelOne );
stack.addStack( "panelTwo", panelTwo );
...
JButton someButton = new JButton( new AbstractAction("Next" ) {
    public void actionPerformed(ActionEvent evt ) {
       stack.showStack( "panelTwo" );
    }
} );