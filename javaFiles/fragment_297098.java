back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                if(!value.equals("") && value != null) {
                   value = value.substring(0, value.length() - 1);
                   numbersArea.setText(value);
                }
        }