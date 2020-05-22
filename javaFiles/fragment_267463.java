final CharSequence[] entries = a.getTextArray(R.styleable.Spinner_android_entries);
if (entries != null) {
    final ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(context,android.R.layout.simple_spinner_item, entries);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        setAdapter(adapter);
}