public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
    String text = inputSearch.getText().toString();
    if(!text.equals("")){
        text = text.toLowerCase(Locale.getDefault());
        listadaptor.filter(text);
    }
}