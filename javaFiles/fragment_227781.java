Intent sendIntent = new Intent();
sendIntent.setAction(Intent.ACTION_SEND);
sendIntent.putExtra(Intent.EXTRA_TEXT, getTextFromAssets("dancerkate.html"));
sendIntent.setType("text/plain");
Intent.createChooser(sendIntent, "Share via");
startActivity(sendIntent);