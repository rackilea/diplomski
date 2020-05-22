private static final String WEB_URL = "https://www.google.ca/";

@Override
public void onClick(View v) {
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_VIEW);
    intent.setData(Uri.parse(WEB_URL));

    Intent clipboardIntent = new Intent(SomeActivity.this, CopyToClipboardActivity.class);
    clipboardIntent.setData(Uri.parse(WEB_URL));

    Intent chooserIntent = Intent.createChooser(intent, "Custom Title...");
    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {clipboardIntent});
    startActivity(chooserIntent);
}