try {
        txtFirstName.getDocument().remove(0, txtFirstName.getText().length());
    } catch (BadLocationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }