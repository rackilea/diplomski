BufferedReader br = new BufferedReader(new FileReader(file));
String line;
while ((line=br.readLine())!=null) {
 ..............
}
br.close();
FileInputStream fis = new FileInputStream(file);
String md5 = DigestUtils.md5Hex(fis);
fis.close();