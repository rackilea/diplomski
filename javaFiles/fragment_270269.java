public void copyFileToSDCard(String fileFrom){
    AssetManager is = this.getAssets();
    InputStream fis;
    try {

        fis = is.open(fileFrom);
        FileOutputStream fos;
        if (!APP_FILE_PATH.exists()) {
            APP_FILE_PATH.mkdirs();
        }
        fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory()+"/MyProject", fileFrom));
        byte[] b = new byte[8];
        int i;
        while ((i = fis.read(b)) != -1) {
            fos.write(b, 0, i);
        }
        fos.flush();
        fos.close();
        fis.close();
    } 
    catch (IOException e1) {
        e1.printStackTrace();
    }
}

public static boolean copyFile(String from, String to) {
try {
    int bytesum = 0;
    int byteread = 0;
    File oldfile = new File(from);
    if (oldfile.exists()) {
        InputStream inStream = new FileInputStream(from);
        FileOutputStream fs = new FileOutputStream(to);
        byte[] buffer = new byte[1444];
        while ((byteread = inStream.read(buffer)) != -1) {
            bytesum += byteread;
            fs.write(buffer, 0, byteread);
        }
        inStream.close();
        fs.close();
    }
    return true;
} catch (Exception e) {
    return false;
}
}