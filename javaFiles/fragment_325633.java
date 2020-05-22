Bundle bundle = FrameworkUtil.getBundle(getClass());

URL url = FileLocator.find(bundle, new Path("/lib/jar_file_name.jar"), null);

url = FileLocator.toFileURL(url);

String path = URIUtil.toFile(URIUtil.toURI(fileURL)).getAbsolutePath();