Intent sharingIntent = new Intent(Intent.ACTION_SEND);
Uri screenshotUri = null;
if(imageUri!=null){
    screenshotUri = Uri.parse(imageUri);
    sharingIntent.setType("image/jpeg");
    sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
}
startActivity(Intent.createChooser(sharingIntent, "Share image using..."));