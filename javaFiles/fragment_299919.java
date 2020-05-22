final AbstractDocument abstractDocument = (AbstractDocument) textArea.getDocument();

  abstractDocument.setDocumentFilter(new DocumentFilter()
    {
      @Override
      public void remove(final FilterBypass fb, final int offset, final int length) throws BadLocationException
      {
        super.remove(fb, offset, length);
      }

      @Override
      public void insertString(final FilterBypass fb,
                               final int offset,
                               final String string,
                               final AttributeSet attr) throws BadLocationException
      {

        if (getLineCountAsSeen(textArea) < 4)
        {
          super.insertString(fb, offset, string, attr);
        }
      }

      @Override
      public void replace(final FilterBypass fb,
                          final int offset,
                          final int length,
                          final String text,
                          final AttributeSet attrs) throws BadLocationException
      {
        if (getLineCountAsSeen(textArea) < 4)
        {
          super.replace(fb, offset, length, text, attrs);
        }
      }
    });