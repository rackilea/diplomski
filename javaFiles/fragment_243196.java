public void updateTextField(final String nextInput) {
  SwingUtilities.invokeLater(
    new Runnable(){
      @Override
      public void run() {
        // assuming a private JTextField variable, myTextField
        myTextField.setText(nextInput);
      }
    }
  );
}