if (EnterPercentage.getText().trim().toString().length() == 0 || EnterPrice.getText().toString().length() == 0 ) {
                //Textfields are empty.
                Log.d("Error","Fields are empty");
            } else {
                //Textfield is full
                float percentage = Float.parseFloat(EnterPercentage.getText().toString());
                float prix = Float.parseFloat(EnterPrice.getText().toString());
                float dec = percentage / 100;
                float total = prix - dec * Float.parseFloat(EnterPrice.getText().toString());
                TotalTextView.setText(String.format("%.2f", total));
            }