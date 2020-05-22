public class MyOnClickListener implements View.OnClickListener {
    final String mValue;
    public MyOnClickListener(String value) {
           mValue = value;
    }

     public void onClick(View v) {
        Log.e(TAG, "O " + mValue);
        // Obtain the value of the EditText with button.getParent()....
     }
}