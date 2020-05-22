File file = new File("path to file");

//checking if the File exists
if (file.exists()) {
    Intent intent = new Intent();

    intent.setAction(Intent.ACTION_VIEW);
    intent.setDataAndType(Uri.fromFile(file), "text/xml");

    //checking if an Activity exists that can handle this Intent
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }
}