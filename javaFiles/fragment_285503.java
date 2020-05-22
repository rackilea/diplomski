private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {
     String[] names = jTextArea11.getText().split("\\n");

     String result = Arrays.stream(names)
              .map(s -> s.replace("Mr:", "")
                         .replace("Miss:", "").replace("Mrs:", ""))
              .collect(Collectors.joining(" "));

     jTextArea12.setText(result);
}