public class CopyToClipboardActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        if (uri != null) {
            copyTextToClipboard(uri.toString());
            Toast.makeText(this, "Link copied to clipboard", Toast.LENGTH_SHORT).show();
        }

        // Finish right away. We don't want to actually display a UI.
        finish();
    }

    private void copyTextToClipboard(String url) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("URL", url);
        clipboard.setPrimaryClip(clip);
    }
}