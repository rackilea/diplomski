//check if character typed is a number
    if (event.getCharacter().matches("[0-9]"))
    {
        event.consume();

        //move caret back one step as we do not want the typed digit
        //and want the caret to remain after last entered text
        textField.backward();

        //delete the typed digit
        textField.deleteNextChar();

    }