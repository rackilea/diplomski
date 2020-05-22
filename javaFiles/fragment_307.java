Intent intent = new Intent(android.content.Intent.ACTION_SEND);
intent.setType("text/plain");
String toShare = "This is the text to share";
// You can add extras
intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");

// Start intent with choose prompt
startActivity(Intent.createChooser(intent, "Share via"));