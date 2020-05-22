URL jar = ...;

 ClassLoader cl = new URLClassLoader(new URL[]{jar});

 ZipInputStream zip = new ZipInputStream(jar.openStream());
 while(true) {
    ZipEntry e = zip.getNextEntry();
    if (e == null)
      break;
    String nameAsInZip = e.getName():

    if(nameAsInZip.endsWith(".class")) {

       String nameForClassLoader = ....; // transform name for CL

       Class clazz = cl.loadClass(nameForClassLoader);

       // analyze class

    }

 }