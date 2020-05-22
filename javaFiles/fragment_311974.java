this.buttons.put( "create", 
    createButton( "Create new definition", new ActionListener(){...} );

public JButton createButton( String label, ActionListener actionListener ){
  JButton button = new JButton( label );
  button.addActionListener ( actionListener );
  return button;
}