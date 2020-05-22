...     
cipher.init(Cipher.ENCRYPT_MODE, secret);
InputStream is = new FileInputStream(choosedFile);
OutputStream os = new CipherOutputStream(new FileOutputStream(choosedFile+".encrypted"), cipher);

byte[] buffer = new byte[1024];
int len;
while ((len = is.read(buffer)) != -1) {
    os.write(buffer, 0, len);
}

is.close();
os.close();
...