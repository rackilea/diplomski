btnAdd.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            num1 = Double.parseDouble(firstNumber.getText().toString());
            num2 = Double.parseDouble(secondNumber.getText().toString());
            sum = num1 / 20 * num2;
            addResult.setText(Double.toString(sum));
        }
    });