// I'm assuming you have this declared in onCreate()
TextView myTextView = (TextView)findViewById(R.id.mytextview); 

if (i < 1) {
    myTextView.setText(getString(R.string.antwort_ja));
} else {
    myTextView.setText(getString(R.string.antwort_nein));
}