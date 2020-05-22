EditText inputText=(EditText)findViewById(R.id.edit);
    String inputString=inputText.getText().toString();


    //To get the selected String
    int selectionStart=inputText.getSelectionStart();
    int selectionEnd=inputText.getSelectionEnd();
    String selectedText = inputString.substring(selectionStart, selectionEnd);

    if(!selectedText.isEmpty())
    {
        //Modify the selected StringHere
        String modifiedString="...your modification logic here...";

        //If you wish to delete the selected text
        String selectionDeletedString=inputString.replace(selectedText,"");
        inputText.setText(selectionDeletedString);

        //If you wish to modify the selected text
        String selectionModifiedString=inputString.replace(selectedText,modifiedString);
        inputText.setText(selectionModifiedString);

    }