calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v) {
            lengths = lengthInput.getText().toString();
            if (lengths.equals("5")) {
                amount.setVisibility(View.VISIBLE);
            }
        }
    });