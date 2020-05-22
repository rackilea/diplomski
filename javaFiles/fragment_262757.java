myButton.addActionListener( new ActionListener() {
    @override public actionPerformed( ActionEvent event )
    {
        String theText = myTextArea.getText();
        myLabel.setText( theText );
    }
} );