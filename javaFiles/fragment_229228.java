if (beu == fourth) {
        for (int i = 0; i < 5; i++) {
            String stars = "";

            for (int j = 0; j < i; j++) {
                stars += " ";
            }
            for (int k = 5; k > i; k--) {
                stars += "*";
            }

            je.setText(stars);
            aslist.addElement(je.getText());
            asterisk.setModel(aslist);
        }
    }