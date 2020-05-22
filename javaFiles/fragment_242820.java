originalString = new StringBuffer();

passwordField.addModifyListener(new ModifyListener() {

public void modifyText(ModifyEvent e) {

    synchronized (passwordField) {

         String s = passwordField.getText();

         String newS = s.replaceAll("[\\s\\S]", "*");
         if (newS.equals(s)) {
             while (originalString.length() > s.length()) {
                 originalString = originalString.deleteCharAt(originalString.length() - 1);
             }
             usernameField.setText(originalString.toString());
             return;
         }

        if (originalString.length() < s.length()) {
            originalString.append(s.charAt(s.length() - 1));
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
        }
        passwordField.setText(newS);
    }

    passwordField.redraw();

    passwordField.setSelection(passwordField.getText().length());
    }

});