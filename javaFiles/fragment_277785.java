private void updateViews(ArrayList<MyArrayType> myParsedArray) {

    // Extract relevant data from the array
    ...

    // Replace the place holders in the relevant views
    EditText myEditText = (EditText) getView().findViewById(R.id.response_dependent_edittext);
    myEditText.setText(stringFromParsedArray);

    ImageView myImageView = (ImageView) getView().findViewById(R.id.response_dependent_imageview);
    myImageView.setImageDrawable(drawableFromParsedArray);

}