if ((!jTextFieldAccountName.getText().isEmpty()) && (jPasswordFieldAccountPassword.getPassword().length > 0)) {
            jButton_Next.setEnabled(true);
        }
        else {
            jButton_Next.setEnabled(false);
        }