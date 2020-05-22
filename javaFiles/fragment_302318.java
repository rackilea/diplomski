public void onClick(View v) {
            try {

                int a = Integer.parseInt(et.getText().toString());
                for (int voo = 0; voo <= 11; voo++) {
                    Integer sam = a * voo;
                    finale.setText(String.valueOf(sam));
                }
            } catch (NumberFormatException e) {

            }
        }