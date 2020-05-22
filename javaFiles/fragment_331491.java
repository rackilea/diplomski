if (isChecked) {
                etPersonTitle.setText("asd");
                etFirstname.setText("asd");
                etSurname.setText("asd");
                etPersonTitle.setEnabled(!isChecked);
                etPersonTitle.setFocusable(!isChecked);
                etFirstname.setEnabled(!isChecked);
                etFirstname.setFocusable(!isChecked);
                etSurname.setEnabled(!isChecked);
                etSurname.setFocusable(!isChecked);
            }

            else {
                etPersonTitle.setText("");
                etFirstname.setText("");
                etSurname.setText("");

                etPersonTitle.setEnabled(true);
                etPersonTitle.setFocusableInTouchMode(true);

                etFirstname.setEnabled(true);
                etFirstname.setFocusableInTouchMode(true);

                etSurname.setEnabled(true);
                etSurname.setFocusableInTouchMode(true);

            }