filterTxtFeild.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
        // put your filter code here upon data insertion
      }

      @Override
      public void removeUpdate(DocumentEvent e) 
      { 
            //put your filter code here upon data removal
      }

      @Override
      public void changedUpdate(DocumentEvent e) {}
    });