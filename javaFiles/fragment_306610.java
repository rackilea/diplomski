private void addEntries(int pos, ArrayList<Integer> rowList) {
   for(int i = 0; i <= 16; i++) {
      //this requires EditText_label, i made them dynamically
      String edit_label = "edit_" + pos + i; 
      EditText editText = table.findViewWithTag(edit_label);
      String mEditTextString = editText.getText().toString();

      try {
         int thisValue = Integer.parseInt(mEditString);
         rowList.set(j, thisValue);
      } catch (NumberFormatException e) {
         //maybe you do not need this, but I need it for something else
         int thisValue = 0;
         rowList.set(j, thisValue);
      }
   }
}