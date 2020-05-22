if (textFieldEntry.getText().trim().matches("[a-zA-Z-]+")){
        arrayWords.add(textFieldEntry.getText());
        labelWords.setText("'"+textFieldEntry.getText()+"' was added to list.");
    }
    else{
        labelWords.setText("The string ‘"+textFieldEntry.getText()+"’ was not added to the list as it is not a valid word.");
    }