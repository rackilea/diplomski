// Gets a word from the UI

mSearchString = mSearchWord.getText().toString();

// Remember to insert code here to check for invalid or malicious input.

String[] mSelectionArgs = null;

// If the word is the empty string, gets everything
if (TextUtils.isEmpty(mSearchString)) {
    // Setting the selection clause to null will return all words
    mSelectionClause = null;
    mSelectionArgs = null;

} else {
    // Constructs a selection clause that matches the word that the user entered.
    mSelectionClause = UserDictionary.Words.WORD + " = ?";

    // Moves the user's input string to the selection arguments.
    mSelectionArgs = new String[] {mSearchString};

}