private String[] getInputArrayFromEditTexts(LinearLayout mParentLayout){
        String[] inputArray = new String [mParentLayout.getChildCount()];
        for (int i = 0; i <inputArray.length ; i++) {
            EditText editText  =(EditText) mParentLayout.getChildAt(i);
            inputArray[i] = editText.getText().toString();
        }
        return inputArray;
    }