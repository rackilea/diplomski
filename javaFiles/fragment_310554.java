ClipData abc = myClipboard.getPrimaryClip();
ClipData.Item item = abc.getItemAt(0);
String text = item.getText().toString();

 Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
 sharingIntent.setType("text/plain");
 sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
 sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
 startActivity(Intent.createChooser(sharingIntent,"Share with");