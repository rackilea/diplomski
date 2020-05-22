TextWatcher watcher = new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int 
 count, int after) {
      }
      @Override
      public void onTextChanged(CharSequence s, int start, int before, 
int count) {
      }

      @Override
      public void afterTextChanged(Editable s) {
          for (EditText et  : new EditText[] {numberOneEditText, 
numberTwoEditText, numberThreeEditText}) {
          try {
            Double.parseDouble(et.getText());
          } catch (NumberFormatException e) {
            // Disable button, show error label, etc.
            button.setEnabld(false);
            return;
          }
        }
       //Enable buttton, hide error label if available
       button.setEnabled(true);
      }
    };
}
numberOneEditText.addTextChangedListener(watcher);
numberTwoEditText.addTextChangedListener(watcher);
numberThreeEditText.addTextChangedListener(watcher);