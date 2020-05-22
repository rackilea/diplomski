File bin = chooser.getSelectedFile();
int filesize = (int) bin.length();
int pcount = (filesize + 2048 - 1) / 2048;
byte[] file = new byte[2048];

FileInputStream fis = new FileInputStream(bin);
String name2 = bin.getName().replace(".bin", ".xyz");
OutputStream os = new BufferedOutputStream(new FileOutputStream(name2));
byte[] rootfile = ("46kb" + "5678" + "0000" + pcount + "MYBOX" + "13" + "S208").getBytes("UTF-8");

for (int n = 0; n < pcount; n++) {
    os.write(rootfile);
    byte[] metas = ("02KB" + "1234" + n).getBytes("UTF-8");
    os.write(metas);

    int len = fis.read(file);

    os.write(file, 0, len);
    int percent = 100 * n / pcount;
    prbar.setValue(percent);
}
ow.close();