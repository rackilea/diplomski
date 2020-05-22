FileOutputStream fout = new FileOutputStream(path + ".txt");
FileInputStream fin = new FileInputStream(path);

System.out.println("File Size:" + path.length());

ByteArrayOutputStream os = new ByteArrayOutputStream();
Base64OutputStream base64out = new Base64OutputStream(os,Base64.NO_WRAP);

byte[] buffer = new byte[3 * 512];
int len = 0;
while ((len = fin.read(buffer)) >= 0) {
    base64out.write(buffer, 0, len);
}

System.out.println("Encoded Size:" + os.size());

base64out.flush();
base64out.close();//this did the tricks. Please see explanation.

String result = new String(os.toByteArray(), "UTF-8");      

fout.write(os.toByteArray());
fout.flush();
fout.close();
os.close();
fin.close();

return result;