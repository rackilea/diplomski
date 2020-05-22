@Test
public void testUrlClassLoader() throws Exception {
    Random random = new Random();
    String newClassName = "Foo" + random.nextInt(1000);
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    List<File> files = new ArrayList<File>();
    File sourceFolder = new File(".");
    File sourceFile = new File(sourceFolder, newClassName + ".java");
    FileWriter fileWriter = new FileWriter(sourceFile);
    fileWriter.write("public class " + newClassName + " { { System.out.println(\""
            + newClassName + " loaded\"); }}");
    fileWriter.close();
    files.add(sourceFile);
    Iterable<? extends JavaFileObject> compilationUnits1 = fileManager
            .getJavaFileObjectsFromFiles(files);
    compiler.getTask(null, fileManager, null, null, null, compilationUnits1).call();
    fileManager.close();

    URL url = sourceFolder.toURI().toURL();
    URLClassLoader urlClassLoader = new URLClassLoader(new URL[] { url });
    Object newInstance = urlClassLoader.loadClass(newClassName).newInstance();
    assertEquals(newClassName, newInstance.getClass().getName());
}