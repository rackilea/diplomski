textArea.getDocument().addDocumentListener( new DocumentListener() {
  public void changedUpdate( DocumentEvent e )
  {
  }

  public void insertUpdate( DocumentEvent e )
  {
    System.out.println( "insertUpdate: Added " + e.getLength() + 
        " characters, document length = " + e.getDocument().getLength() );
  }

  public void removeUpdate( DocumentEvent e )
  {
    System.out.println( "removeUpdate: Removed " + e.getLength() +
        " characters, document length = " + e.getDocument().getLength() );
  }
});