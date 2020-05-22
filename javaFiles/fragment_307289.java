public byte[] method() {
   File f =loadFile();
                FileInputStream fis = new FileInputStream(f);
                byte[] data = new byte[fis.available()];
                fis.read(data);
                f.delete();
    return data;
}