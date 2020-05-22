Intent intent = new Intent();
intent.setAction(Intent.ACTION_VIEW);
intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Ensure app runs in separate task
Uri uri = Uri.fromFile(downloadedFile);
String mimeType = document.getMimeType();
intent.setDataAndType(uri, mimeType);
startActivity(intent); // Can't use startActivityForResult() here