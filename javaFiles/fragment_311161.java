//if you do not have a reference to the EditText already -- this uses the IDs in your question
EditText nameEditText = (EditText) myTableLayout.findViewById(10000);
EditText emailEditText = (EditText) myTableLayout.findViewById(10001);
String nameValue = nameEditText.getText().toString();
String emailValue = emailEditText.getText.toString();

// now you can do whatever you need to with the values
AlertDialog dialog = new AlertDialog.Builder(this)
            .setTitle("Your Inputs")
            .setMessage("Name is: " + nameValue + ", Email is: " + emailValue)
            .create();
dialog.show();