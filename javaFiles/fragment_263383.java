File dllFile = File.createTempFile("jinvoke", ".dll");
InputStream input = new URL(getCodeBase(), "lib/jinvoke.dll").openStream();
OuptutStream output = new FileOutputStream(dllFile);
// Write input to output and close streams the usual Java IO way.

// Then load it using absolute disk file system path.
System.loadLibrary(dllFile.getAbsolutePath());
dllFile.deleteOnExit();