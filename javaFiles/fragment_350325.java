CodeSource codeSource = MyClass.class.getProtectionDomain().getCodeSource();
File jarFile = new File(codeSource.getLocation().toURI().getPath());
File jarDir = jarFile.getParentFile();

if (jarDir != null && jarDir.isDirectory()) {
  File propFile = new File(jarDir, "myFile.properties");
}