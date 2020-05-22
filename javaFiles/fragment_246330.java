File file = new File("/data/test/userid/feedid/test.flv");
File parent = file.getParentFile();
if (parent.exists() || parent.mkdirs()) {
   //...
} else {
    throw new IOException("Failed to create output directory " + parent);
}