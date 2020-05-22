shell.setLayout( new FormLayout() );
FormData leftFormData = new FormData();
leftFormData.top = new FormAttachment( 0 );
leftFormData.left = new FormAttachment( 0 );
leftFormData.right = new FormAttachment( 20 );
Label leftLabel = createLabel( shell, "2020", leftFormData );
FormData rightFormData = new FormData();
rightFormData.top = new FormAttachment( 0 );
rightFormData.left = new FormAttachment( leftLabel );
rightFormData.right = new FormAttachment( 100 );
createLabel( shell, "808080808080", rightFormData );

private static Label createLabel( Composite parent, String text, Object layoutData ) {
  Label label = new Label( parent, SWT.NONE );
  label.setText( text );
  label.setLayoutData( layoutData );
  return label;
}