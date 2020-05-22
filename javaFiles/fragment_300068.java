private void ButtonClick() {
    View v;
    CheckBox chBox;
    for (int i = 0; i < myList.getCount(); i++) {
        v = myList.getAdapter().getView(i, null, null);
        chBox = (chBox) v.findViewById(R.id.checkBox);//your xml id value for checkBox.
        if (chBox.isChecked()) {
            doSomething();
        }
    }
....
}