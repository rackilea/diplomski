public void getDirections(View view) {

        String startingAddress = et_address.getText().toString();
        String finalAddress = et_finalAddress.getText().toString();

        if ((startingAddress.equals("")) || finalAddress.equals("")) {
            Toast.makeText(this, "Enter a starting and Ending address", Toast.LENGTH_SHORT).show();
        } else {
            new GetDirections().execute(startingAddress, finalAddress);
        }
    }