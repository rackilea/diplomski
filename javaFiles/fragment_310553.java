ClipboardManager myClipboard;
myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
ClipData myClip;
String text=textView.getText().toString();
myClip = ClipData.newPlainText("text", text);
myClipboard.setPrimaryClip(myClip);