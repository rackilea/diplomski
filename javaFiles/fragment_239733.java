Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
intent.addCategory(Intent.CATEGORY_OPENABLE);
intent.setType("text/plain");
intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, your_initial_uri);
intent.putExtra(Intent.EXTRA_TITLE, fileName);
startActivityForResult(intent, CREATE_REQUEST_CODE);