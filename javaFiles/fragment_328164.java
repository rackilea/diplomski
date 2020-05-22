Intent i = new Intent(Intent.ACTION_SEND);
i.setType("text/plain");
i.putExtra(Intent.EXTRA_TEXT,message);
try {
     context.startActivity(Intent.createChooser(i, "Share"));
} catch (android.content.ActivityNotFoundException ex) {
     ex.printStackTrace();
}