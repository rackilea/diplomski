String textToPaste = null;

ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);

if (clipboard.hasPrimaryClip()) {
    ClipData clip = clipboard.getPrimaryClip();

    // if you need text data only, use:
    if (clip.getDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))
        // WARNING: The item could cantain URI that points to the text data.
        // In this case the getText() returns null and this code fails!
        textToPaste = clip.getItemAt(0).getText().toString();

    // or you may coerce the data to the text representation:
    textToPaste = clip.getItemAt(0).coerceToText(this).toString();
}

if (!TextUtils.isEmpty(textToPaste))
     ((TextView)findViewById(R.id.etInput1)).setText(textToPaste);