@Override
    public void onClick(View v)
    {
        // Take what was typed into the EditText and use in TextView
        mainTextView.setText(mainEditText.getText().toString()
                + " is yoloing on Android development!");
        mArrayAdapter.add(mainEditText.getText().toString());
    }