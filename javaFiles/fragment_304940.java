public class MyAutocompleteDocument extends DefaultStyledDocument {

  @Override
  public void insertString ( int offs, String str, AttributeSet a ) throws BadLocationException
  {
    if ( !StringUtils.isBlank( str ) )
    {
        String text = getText( 0, offs ); // Current text up to insert point
        String completion = complete( text + str ); // Full completed string

        if (!StringUtils.isBlank( completion )) { // not "" or null
            String textToInsert = completion.substring( offs );

            // Always overwrite on complete
            int oldLength = getLength();
            remove( offs, oldLength - offs );
            super.insertString( offs, textToInsert, a );

            // Select the auto-completed portion so it's easy to keep typing
            owner.select( offs + str.length(), getLength() );
        } else {
            super.insertString( offs, str, a );
        }
    }
  }

  private String complete(String startsWith) {
      // access service to search for completion
  }
}