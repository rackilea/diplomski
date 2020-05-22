public class MyNumericVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
       String text = ((JTextField) input).getText();
       try {
          Integer.parseInt(text);
       } catch (NumberFormatException e) {
          return false;
       }

       return true;
    }
}

InputVerifier verifier = new MyNumericVerifier()
textField1.setInputVerifier(verifier);