buttonSubtract.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            String number1 = editTextNumber1.getText().toString().trim();
            String number2 = editTextNumber2.getText().toString().trim();
            if (!number1.isEmpty() && !number2.isEmpty()) {
                try {
                    int sum = Integer.parseInt(number1)
                            + Integer.parseInt(number2);
                    textSum.setText("sum: " + sum);
                    return;

                } catch (NumberFormatException e) {
                    // nothing to do
                }
            }
            textSum.setText("Put numbers in both fields");
        }
    });