ClassLoader classloader =
         org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
URL res = classloader.getResource(
         "org/apache/poi/poifs/filesystem/POIFSFileSystem.class");
String path = res.getPath();
System.out.println("Core POI came from " + path);