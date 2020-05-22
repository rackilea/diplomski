public void actionPerformed(ActionEvent ae) {
        String text = txtField.getText().trim();
        matcher1 = pattern1.matcher(text);
        matcher2 = pattern2.matcher(text);
        if (matcher1.matches()) {
            if (!matcher2.matches()) {
                lbl.setText("Not a valid IP Address");
            } else {
                lbl.setText("Valid IP Address");
            }
        } else {
            lbl.setText("Not an IP Address");
        }
    }