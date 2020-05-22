shell.setLayout( new RowLayout( SWT.VERTICAL ) );
Composite composite1 = new Composite( shell, SWT.NONE );
composite1.setLayout( new GridLayout( 2, false ) );
createLabel( composite1, "2020" );
createLabel( composite1, "808080808080" );

Composite composite2 = new Composite( shell, SWT.NONE );
composite2.setLayout( new GridLayout( 2, false ) );
createLabel( composite2, "50505050" );
createLabel( composite2, "50505050" );

private static Label createLabel( Composite parent, String text ) {
  Label label = new Label( parent, SWT.NONE );
  label.setText( text );
  return label;
}