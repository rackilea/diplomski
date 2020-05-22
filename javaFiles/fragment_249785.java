Project p = new Project();
Untar ut = new Untar();
ut.setProject(p);
ut.setSrc(tarFile);
if(tarFile.getName().endsWith(".gz")) {
  ut.setCompression((UntarCompressionMethod)EnumeratedAttribute.getInstance(UntarCompressionMethod.class, "gzip"));
}
ut.setDest(destDir);

ut.perform();