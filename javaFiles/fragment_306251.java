//Prepare object of Edit Text
    EditText editText = (EditText) findViewById(R.id.editText1);
    //Get String entered by user
    String enteredText = editText.getText().toString();
    //split string to get every word using _ (space) and add all word to an array
    String[] words = enteredText.split(" ");
    for (int i = 0; i < words.length; i++) {
        if (words[i].length() > 10) {
            //handle if any word is > 10 ch.
            break;
        }else{
             //handle if word is meaning full or not
        }
    }