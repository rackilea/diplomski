@Override
public void onClick(View v) {
    //cast view to button
    Button bt = (Button) v;

    //get text from button
    final String letter = bt.getText().toString();

    //pass it to displayLetters()
    displayLetters(letter);
}