public Uri renameFile(ContentResolver contentResolver, Uri uri, String newFilename) {
        Uri newLink = null;
        try {
            newLink = DocumentsContract.renameDocument(context, uri, newFilename);
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return newLink;
    }

    Task<FileList> queryFile(String newFileName) {
        return Tasks.call(mExecutor, () ->
                service.files().list()
                    .setQ("mimeType='application/vnd.google-apps.spreadsheet'")
                    .setQ("fullText contains " + "'" + newFileName + "'")
                    .setQ("trashed = false")
                    .setFields("files(id, name)")
                    .execute()
        );
    }