private EditText[] mEditTextPlayers;

public void goButtonClicked(View view) {
    maalContainer.removeAllViews();
    int numPlayers = Integer.parseInt((String) numberOfPlayers.getSelectedItem());

    LayoutInflater inflater = LayoutInflater.from(view.getContext());
    mEditTextPlayers = new EditText[numPlayers];

    for (int i = 0; i < numPlayers; i++) {
        //Pass the parent as the second parameter to retain layout attributes
        mEditTextPlayers[i] = inflater.inflate(R.layout.player_entry_item, maalContainer, false);
        maalContainer.addView(dynamicEntryView);
    }
}