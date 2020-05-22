/*I dont know if I could set column final in general, 
but you need to set a final int because you call this value in an inner class*/

final int pos = column 

for (int i = 0; i <= getEditTexts(pos).size() - 1; i++) {
EditText editTexts = getEditTexts(pos).get(i);
final String editTextsTag = editTexts.getTag().toString();

View.OnFocusChangeListener listener = new View.OnFocusChangeListener() {
   @Override
   public void onFocusChange(View view, final boolean b) {
      if (view.getTag().toString().equals(editTextsTag) && !b) {
        //fills rowList
        addEntries(pos, rowList);

        //adds rowList to columnArray
        columnArray.set(pos, rowList);

        //save the columnsArray or use it 
        saveData(columnArray);
      }
   }
};
editTexts.setOnFocusChangeListener(listener);