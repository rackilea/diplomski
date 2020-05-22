public void functionCalculator(View view) {

    try {
        // Firstly checking for integers
        int number1, number2;
        number1 = Integer.parseInt(e1.getText().toString());
        number2 = Integer.parseInt(e2.getText().toString());

        if (view.getId() == R.id.button1)
            t1.setText(Integer.toString(number1 + number2));

        else if (view.getId() == R.id.button2)
            t1.setText(Integer.toString(number1 - number2));

    } catch (NumberFormatException e) {
        float number1, number2;

        try {
            // Now checking for decimals
            number1 = Float.parseFloat(e1.getText().toString());
            number2 = Float.parseFloat(e2.getText().toString());

            if (view.getId() == R.id.button1)
                t1.setText(Float.toString(number1 + number2));

            else if (view.getId() == R.id.button2)
                t1.setText(Float.toString(number1 - number2));

        } catch (NumberFormatException e2) {
            // No numbers :(
            Toast.makeText(this, "WTF! Enter number here you dingus!", Toast.LENGTH_SHORT).show();
        }
    }

}