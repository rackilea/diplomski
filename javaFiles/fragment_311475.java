widthField.getDocument().addDocumentListener(new DocumentListener() {
      public void changedUpdate(DocumentEvent e) {
          update();
      }
      public void removeUpdate(DocumentEvent e) {
          update();
      }
      public void insertUpdate(DocumentEvent e) {
          update();
      }

      // your method that handles any Document change event
      public void update() {
          if( aspectCheckBox1.isSelected() ) {

            // parse the width and height, 
            // constrain the height to the aspect ratio and update it here              
          }
      }

    });