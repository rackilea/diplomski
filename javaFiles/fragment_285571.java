button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              int fromValue = Integer.parseInt(fromValueEditText.getText().toString());
              int toValue = Integer.parseInt(toValueEditText.getText().toString());
              int randomNumber = generateRandomNumberBetweenRange(fromValue, toValue);
              //Your random Number is generated, you can now do whatever you want with it.
              }
          });