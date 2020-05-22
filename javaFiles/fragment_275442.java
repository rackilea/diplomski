ClipboardManager clipboard=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
String text = textView.getText().toString();

// item is the most recent Clip from the Clipboard
ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);

// Gets the clipboard as text.
String clipText = item.getText().toString(); // getText() returns CharSequence

if ( !(clipText.equals(text)) )
{
    clipboard.setPrimaryClip(ClipData.newPlainText("newClipName", text));
    Toast.makeText(getApplicationContext(),"Copied to clipboard.", 0).show(); 
}