String folder_root = "Pictures";

File f = new File(Environment.getExternalStorageDirectory(), folder_root);
if (!f.exists()) {
    f.mkdirs();
}

File f1 = new File(Environment.getExternalStorageDirectory() + "/" + folder_root, "yourDirectoryName");
if (!f1.exists()) {
    f1.mkdirs();
}