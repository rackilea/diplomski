private void language1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        RSyntaxTextArea syntaxTextArea = new RSyntaxTextArea(6, 20);

        String lang = (String) language1.getSelectedItem();
        syntaxTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        msg1 = syntaxTextArea;
        msg1.setVisible(true);