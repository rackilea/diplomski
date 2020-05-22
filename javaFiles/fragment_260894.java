FileInputStream fin = new FileInputStream(file);
BufferedReader reader = new BufferedReader(new InputStreamReader(fis), 64 * 1024);
StringBuilder sb = new StringBuilder();
String line = null;
while ((line = reader.readLine()) != null) {
  sb.append(line).append("\n");
}
reader.close();