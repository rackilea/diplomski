//...
        } else {
            try {
                float i = Float.parseFloat(inputs);
                i= ((i * 9) / 5) + 32;
                outputTextBox.setText(String.valueOf(i));
            } catch (NumberFormatException e) {
                outputBox.setText("0");
            }
        }
        //...