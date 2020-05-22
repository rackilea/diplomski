Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
Uri uri=Uri.parse("file:///android_asset/myimage.png"); 
whatsappIntent.setType("image/*");
whatsappIntent.setPackage("com.whatsapp");
sendIntent.putExtra(Intent.EXTRA_STREAM,uri);
try {
    activity.startActivity(whatsappIntent);
} catch (android.content.ActivityNotFoundException ex) {
    ToastHelper.MakeShortText("Whatsapp have not been installed.");
}