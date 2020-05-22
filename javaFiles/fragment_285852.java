Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
whatsappIntent.setType("text/plain");
whatsappIntent.setPackage("com.whatsapp");
whatsappIntent.putExtra(Intent.EXTRA_TEXT, "This is a test text");
try {
    activity.startActivity(whatsappIntent);
} catch (android.content.ActivityNotFoundException ex) {
    ToastHelper.MakeShortText("Whatsapp have not been installed.");
}