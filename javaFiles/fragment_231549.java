public void sendFeedback(View button) {
    Toast.makeText(this, "Do not fail", Toast.LENGTH_SHORT).show();
    final EditText nameField = (EditText) findViewById(R.id.Name);
    if(nameField != null) {
        String name = nameField.getText().toString();

        if (!name.isEmpty()) {
            Toast.makeText(this, "Name: " + name, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Namefield is empty!" , Toast.LENGTH_SHORT).show();
        }
    }
    final EditText numberField = (EditText) findViewById(R.id.Cost);
    if(numberField != null) {
        String test = numberField.getText().toString();
        if(!test.isEmpty()) {
            int x = Integer.parseInt(test.trim());
            Toast.makeText(this, "Cost: " + x, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You haven't entered a number", Toast.LENGTH_SHORT).show();
        }
    }
}