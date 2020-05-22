String externalStorageDirAbsPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    File file = new File(externalStorageDirAbsPath + File.separator + "a" + File.separator + "b" + File.separator + "c.txt");
    if (file.exists()) {
        // first rename a to d
        boolean res = new File(externalStorageDirAbsPath + File.separator + "a")
                        .renameTo(new File(externalStorageDirAbsPath + File.separator + "d"));
        if (res) {
            // rename b to e
            res = new File(externalStorageDirAbsPath + File.separator + "d" + File.separator + "b")
                    .renameTo(new File(externalStorageDirAbsPath + File.separator + "d" + File.separator + "e"));
            if (res) {
                // rename c.txt to f.txt
                res = new File(externalStorageDirAbsPath + File.separator + "d" + File.separator + "e" + File.separator + "c.txt")
                        .renameTo(new File(externalStorageDirAbsPath + File.separator + "d" + File.separator + "e" + File.separator + "f.txt"));
            }
        }
        Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_SHORT).show();
    }