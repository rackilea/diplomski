String manifestPath = classPath.substring(0, webInfIndex) +
        "/META-INF/MANIFEST.MF";

// DON'T DO THIS!!!
// openStream() returns an InputStream that never gets closed.
Manifest manifest = new Manifest(new URL(manifestPath).openStream());
Attributes attr = manifest.getMainAttributes();
String version = attr.getValue(Attributes.Name.IMPLEMENTATION_VERSION);