try {
                i = Integer.parseInt(ed);
                // setting value here
                text.setText(String.valueOf(i));
                // or you can do like this
                // text.setText(String.valueOf(i));
                updatedvalueOfi(i);
            } catch (NumberFormatException ex) {
                text.setText("Value at TextView is not a valid integer");
            }