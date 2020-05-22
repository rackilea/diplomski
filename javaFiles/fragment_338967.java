comboBox.addFocusListener(new FocusAdapter() {

   @Override
   public void focusGained(FocusEvent e) {
      comboBox.showPopup();
   }
});