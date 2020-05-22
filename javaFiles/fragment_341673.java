Intent intent = new Intent();
intent.setAction(Intent.ACTION_SEND_MULTIPLE);
intent.putExtra(Intent.EXTRA_SUBJECT, "Here are some files.");
intent.setType("image/jpeg"); /* This example is sharing jpeg images. */

ArrayList<Uri> files = new ArrayList<Uri>();

for(String path : filesToSend /* List of the files you want to send */) {
    File file = new File(path);
    Uri uri = Uri.fromFile(file);
    files.add(uri);
}

intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
startActivity(intent);