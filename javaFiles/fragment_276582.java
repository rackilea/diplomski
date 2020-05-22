public class CallMutant {

    public static void main(String[] args) throws IOException {
        // get mutant list
        List<String> list = FolderIterator.getFilesPath();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Iter: "+ i);
            File source = new File(list.get(i));
            File dest = File.createTempFile("FFT", ".java");
            dest.deleteOnExit();
            System.out.format("Canonical filename: %s\n", dest.getCanonicalFile());

            //copy file using Stream
            try {
                copyFileUsingStream(source, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // generate the source code, using the source filename as the class name
            String classname = dest.getName().split("\\.")[0];
            Path path = Paths.get(String.valueOf(dest));
            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll("public class FFT", "public class " + classname);
            Files.write(path, content.getBytes(charset));

            // compile the source file
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            File parentDirectory = dest.getParentFile();
            fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(parentDirectory));
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(dest));
            compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
            fileManager.close();

            // load the compiled class
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{parentDirectory.toURI().toURL()});
            Class<?> helloClass = null;
            try {
                helloClass = classLoader.loadClass(classname);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("No class found");
            }

            // call a method on the loaded class
            Method helloMethod = null;
            try {
                Complex[] params2 = new Complex[1];
                helloMethod = helloClass.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                System.out.println("No Method found");
                e.printStackTrace();
            }
            try {
                String[] params = {"1"};
                helloMethod.invoke(helloClass.newInstance(), (Object) params);
            }catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            os.write("import com.company.originals.Complex;\n".getBytes());
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}