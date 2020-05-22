editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        // Convert the editable to int.
        int userInput = Integer.parseInt(s.getText().toString());
        // First we want to copy the data ArrayList so we don't affect the original one.
        ArrayList<Data> new = copyArray(originalDataArrayList);
        // Then we want to run a for loop to change the item count depending on the userInput value.
        for (int i = 0; i < newArray.size(); i++){
          if (i >= userInput){
            newArray.remove(i);
        }
      }
        // Now we have ArrayList with the required size.
        // Here you create a new adapter and pass the new ArrayList to it and set the ListView adapter as the new adapter.
    }
});