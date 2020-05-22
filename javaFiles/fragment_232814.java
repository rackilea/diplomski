Uri imageUri = Uri.parse(pictureFile.getAbsolutePath());
Intent shareIntent = new Intent();
shareIntent.setAction(Intent.ACTION_SEND);
//Target whatsapp:
shareIntent.setPackage("com.whatsapp");
//Add text and then Image URI
shareIntent.putExtra(Intent.EXTRA_TEXT, picture_text);
shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
shareIntent.setType("image/jpeg");
shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

try {
    startActivity(shareIntent);
} catch (android.content.ActivityNotFoundException ex) {
    ToastHelper.MakeShortText("Whatsapp have not been installed.");
}