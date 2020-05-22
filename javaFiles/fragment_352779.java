private void createCheckBoxes(final int count) {
    for (int i = 0;i < count; i++) {
        final CheckBox checkBox = createCheckBox(this, strings[i], i);
        mainlayout.addView(checkBox);
    }
}

private CheckBox createCheckBox(final Context context, final String text, final int id) {
    final CheckBox checkBox = new CheckBox(context);

    checkBox.setTag(id);
    checkBox.setText(text);
    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
            if (isChecked) {
                System.out.println("Checked");
            } else {
                System.out.println("Unchecked");
            }
        }
    });

    return checkBox;
}