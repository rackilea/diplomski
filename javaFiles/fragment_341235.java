ZipEntry ze = null;
while ((ze = zin.getNextEntry()) != null) {
  System.out.println("Unzipping " + ze.getName());
  FileOutputStream fout = new FileOutputStream(ze.getName());
  for (int c = zin.read(); c != -1; c = zin.read()) {
  ...