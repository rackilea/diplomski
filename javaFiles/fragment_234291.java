JTextField arabicTextField = new JTextField(...);
JTextField romanTextField = new JTextField(...);

AbstractDocument arabicDocument = (AbstractDocument)arabicTextField.getDocument();
arabicDocument.setDocumentFilter( new ConversonFilter(true, romanTextField) );

AbstractDocument romanDocument = (AbstractDocument)romanTextField.getDocument();
romanDocument.setDocumentFilter( new ConversonFilter(false, arabicTextField) );