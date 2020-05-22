public void importaTabelas() {

    //Check the read permission
    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
        try {
            makeDirs();

            //Read all file names
            for (File f : importDir.listFiles()) {
                if (f.isFile()) {
                    importFile(f);
                }
            }
        } catch (IOException e) {
            Toast.makeText(this, "Could not import tables! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    } else {
        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
    }

}