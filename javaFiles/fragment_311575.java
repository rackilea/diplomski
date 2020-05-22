public void backspace (View view) {
    TextView textViewCalcCurrExp = (TextView)findViewById(R.id.textViewCalcCurrExp);

    try {
        if (arrayList.size() > 0 ) {
            // it will remove the 2 on index 0 because your 2 is no zero index                           
            arrayList.remove(0);
        }

        String string = textViewCalcCurrExp.getText().toString();//its coming empty
        if(string.length() > 0) {
            // removing the last character from the TextView
            textViewCalcCurrExp.setText(string.substring(0, string.length() - 1));
        }else{
             // if array list is zero than set textview as "";
           textViewCalcCurrExp.setText(string.substring("");

           }


    }
    catch (Exception e) {
        TextView textViewCalcCurrRes = (TextView)findViewById(R.id.textViewError);
        textViewCalcCurrRes.setText("ERROR");
    }
}