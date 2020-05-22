public void onClick(View v) {

        // If you want to implement a max number of guesses, detect the 
        // number of guesses and return from the method.
        if (guesses > 5) {
            Toast.makeText(MainActivity.this, "Out of guesses!", Toast.LENGTH_SHORT);
            return;
        }

        String value = text.getText().toString(); // Get value from input from editTextView
        // If the user submits an empty EditText, return so we don't crash when parsing int
        if (value.isEmpty()) {
            Toast.makeText(MainActivity.this, "You must enter a guess!", Toast.LENGTH_SHORT);
            return;
        }
        input = Integer.parseInt(value); // Turn string into integer
        guesses++;
        if(input > comp)
            Toast.makeText(MainActivity.this, 
                "Number is too big.", 
                Toast.LENGTH_SHORT).show();
        else if (input < comp)
            Toast.makeText(MainActivity.this, 
                "Number is too small.", 
                Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, 
                "Good job! That was correct." +
                "You made " + guesses + " guesses.", 
                Toast.LENGTH_SHORT).show();

    }