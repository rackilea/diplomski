try {
        value_1 = Double.parseDouble(tf_1.getText());   
    } catch (NumberFormatException e) {
        // here you know that tf_1 is non-double
        tf_1.setBackground(Color.red);
        tf_1.requestFocus();
    }