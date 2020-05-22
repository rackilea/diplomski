protected TextArea getNewTextArea() {
    if ( newTextArea == null ) {

        final String initialText;
        if (isItA){
            initialText = "Please paste valid text A here, and then
            press" + "the \"" + Labels.ADD_A_BUTTON_TEXT + "\" button.";

        }else{
            initialText = "Please paste valid text B here, and then press " + "the \"" + Labels.ADD_B_BUTTON_TEXT + "\" button.";
        }


        newTextArea = new TextArea();
        newTextArea.setText( initialText );
        newTextArea.addClickHandler( new ClickHandler() {
            public void onClick( ClickEvent clickEvent ) {
                // If the text is still the original text, then clear it.
                if ( newTextArea.getText().equals( initialText ) ) {
                    newTextArea.setText( "" );
                }

            }
        } );
    }