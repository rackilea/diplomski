Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
 intent.setType("vnd.android.document/directory");
 intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
 intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
 intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
 startActivityForResult(intent, CREATE_DIRECTORY_REQUEST_CODE);