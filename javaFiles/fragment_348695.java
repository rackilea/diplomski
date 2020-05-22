text1.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        if(e.keyCode == SWT.CR) {
            String textData = text1.getText();
            text1.setText("");

            // HERE IS THE IMPORTANT CODE PART, NO SELECTION IS NEEDED
            e.doit = false;
        }
    }
});