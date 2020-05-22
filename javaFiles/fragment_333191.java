@Override
    public void actionPerformed(ActionEvent e) {
        int a = 0, b = 0, c = 0;
        boolean isValidA = true, isValidB = true, isValidC = true;

        try {
            a = Integer.parseInt(theApp.tred.getText());
        } catch (NumberFormatException ex) {
            isValidA = false;
        }

        try {
            b = Integer.parseInt(theApp.tgreen.getText());
        } catch (NumberFormatException ex) {
            isValidB = false;
        }

        try {
            c = Integer.parseInt(theApp.tblue.getText());
        } catch (NumberFormatException ex) {
            isValidC = false;
        }

        if (!isValidA) {
            tred.setText("");
        } else {
            if (a < 0) {
                a = 200;
                tred.setText("200");
            } else if (a > 255) {
                a = 255;
                tred.setText("255");
            }
        }

        if (!isValidB) {
            tgreen.setText("");
        } else {
            if (b < 0) {
                b = 200;
                tgreen.setText("200");
            } else if (b > 255) {
                b = 255;
                tgreen.setText("255");
            }
        }

        if (!isValidC) {
            tblue.setText("");
        } else {
            if (c < 0) {
                c = 200;
                tblue.setText("200");
            } else if (c > 255) {
                c = 255;
                tblue.setText("255");
            }
        }
        if (isValidA && isValidB && isValidC) {
            message.setText("CE203 Assignment submitted by: Steven Beresford - 1404398");
            message.setForeground(new Color(a, b, c));
        } else {
            message.setText("invalid input! please enter numbers only");
            message.setForeground(new Color(0, 0, 0));
        }

    }