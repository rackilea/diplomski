ZipInputStream zis = new ZipInputStream(new FileInputStream("fileName"));
ZipEntry entry;
while ((entry = zis.getNextEntry())!=null) {
    if (entry.isDirectory()) {
        continue;
    }
    if (!entry.getName().endsWith(".class")) {
        continue;
    }
    Class theClass = Class.forName(entry.getName());
    Endpoint targetAnnotation = theClass.getAnnotation(Endpoint.class);
    if (targetAnnotation == null) {
        continue;
    }
    //probably what youre looking for
}