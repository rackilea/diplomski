@Override
public void onBackPressed() {
    super.onBackPressed();
    File dir = getBaseContext().getExternalFilesDir("TempFolder");
    deleteRecursive(dir);
}

void deleteRecursive(File fileOrDirectory) {
    if (fileOrDirectory.isDirectory())
        for (File child : fileOrDirectory.listFiles())
            deleteRecursive(child);

    fileOrDirectory.delete();
}