t1button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // --- find the text view --
            EditText inputText = (EditText) findViewById(R.id.NameText);
            String str = inputText.getText().toString() + "\n"; // add new line so each person is on their own line
            TextView newText = (TextView) findViewById(R.id.team1_person1);
            newText.append(str); // change setText to append.
        }
    });