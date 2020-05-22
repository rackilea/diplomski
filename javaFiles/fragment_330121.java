b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button b = (Button) view;
            String s = b.getText().toString();
            switch (s){
                case "S" : {
                    b.setText("O");
                    break;
                }
                case "O" : {
                    b.setText("");
                    break;
                }
                case "" : {
                    b.setText("S");
                    break;
                }
            }
        }
    });