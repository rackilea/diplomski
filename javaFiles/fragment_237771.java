try {
    File f = fc.getSelectedFile();
    path = f.getAbsolutePath();
    path = path.replace("\\", "/");
    path = path + " _ " + new Date().getTime() + ".sql";
    jTextField5.setText(path);
} catch (Exception e) {
    e.printStackTrace();
}