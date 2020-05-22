public void OnExtractButtonClick(View view) {

    EditText mainEditText1 = (EditText) findViewById(R.id.mainEditText1);
    String txt = mainEditText1.getText().toString();
    String[] words = txt.split("\\s+");

    List<String> resultList = new ArrayList<>();

    for (String word: words) {
        if (word.contains("@")) {
            // this is where you're creating a new "screen" per message
            // Intent intent = new.Intent(this, SubActivity.class);
            // intent.putExtra("word2", word);
            // startActivity(intent);

            // instead we store a word into a list if it's a match:
            resultList.add(word);
        }

        if (!txt.contains("@")) {
            Toast.makeText(MainActivity.this, "No email. address found in the document!", Toast.LENGTH_LONG).show();
        }

        //How do i get all the emails found printed in one text field and on one activity.

        // create a String that displays the emails in a way you like,
        // e.g. separated by newlines:
        String result = TextUtils.join("\n", resultList);
        mainEditText1.setText(result);
    }
}