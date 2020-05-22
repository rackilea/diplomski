Bundle extras = getIntent().getExtras();
if (extras == null) {
        return;
        }
// Get data via the key
String value = extras.getString(Intent.EXTRA_TEXT);
if (value != null) {
    setAttr(value)
}