public void onClick() {

        String usnm = txtField.getText();
        String pass = passField.getText();

        String acc;

        if (usnm.equals(USNM)) {
            if (pass.equals(PASS)) {
                acc = ACCESS_GRANTED;
            } else {
                acc = ACCESS_DENIED;
            }
        } else {
            acc = ACCESS_DENIED;
        }

        System.out.println(acc);
    }