Button.setOnClickListener(new OnClickListener() {
public void onClick(View v) {

Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
    "mailto",yourEditTextObj.getText(), null));
emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
startActivity(Intent.createChooser(emailIntent, "Send email..."));
}
});