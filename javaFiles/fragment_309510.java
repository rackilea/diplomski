@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    CustomSave data = (CustomSave)getLastCustomNonConfigurationInstance();
    if(data==null) return;

    for(int i = 0; i<data.texts.size();i++){
        addEdit(data.texts.get(i));
    }
}