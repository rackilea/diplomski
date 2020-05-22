onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 1) {
        if(resultCode == RESULT_OK) {
            String myStr=data.getStringExtra("MyData");
            mTextView.setText(myStr);
        }
    }
}