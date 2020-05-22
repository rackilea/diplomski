Hashmap<String, Uri> imageUriMap = new Hashmap<>; //Defined outside of this method

public String indexImages(Uri userSelectedDirUri){

    ContentResolver contentResolver = this.getContentResolver(); //When this method is used in the context of an Activity.
    Uri childrenUri = DocumentsContract.buildChildDocumentsUriUsingTree(uri,
            DocumentsContract.getTreeDocumentId(uri));

    Cursor c = null;

    c = contentResolver.query(childrenUri, new String[] {
            DocumentsContract.Document.COLUMN_DISPLAY_NAME,
            DocumentsContract.Document.COLUMN_DOCUMENT_ID}, null, null, null);

    Integer count = 0;
    try {
        while (c.moveToNext()) {
            final String documentName = c.getString(0);
            final String documentId = c.getString(1);
            final Uri documentUri = DocumentsContract.buildDocumentUriUsingTree(uri,
                    documentId);
            imageUriMap.put(documentName, documentUri);
            count++;
        }
    } finally {
        c.close();

    }
    return (count.toString() + " images indexed");
}