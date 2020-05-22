public static void main(String[] args) throws Exception {   
    Loader loader = new Loader();
    loader.addTranslator(ClassPool.getDefault(), new Profiler());
    try {
        if (args.length < 1) {
            System.out.println(TOOL_USAGE);
        } else {

            //Initialize profiler with config/config.properties file
            initializeProfiler();

            final String[] commandArgs = new String[args.length - 1];
            System.arraycopy(args, 1, commandArgs, 0, commandArgs.length);

            //Open a jar file, unJar it into /tmp/ then add the /tmp/ classpath to the javassist laoder
            File file = new File(args[0]);
            JarFile jarFile = new JarFile(args[0]);
            Manifest manifest = jarFile.getManifest();
            String mainClassName = null;

            if (manifest != null) {
                mainClassName = manifest.getMainAttributes().getValue("Main-Class");
            }

            jarFile.close();

            mainClassName = mainClassName.replaceAll("/", ".");
            //Default temp directory is Jarfilename without .jar
            final File workDir = File.createTempFile(args[0].substring(0, args[0].indexOf('.')), "");
            workDir.delete();
            workDir.mkdirs();

            //Unjar all files into WorkDir temp directory
            unJar(file, workDir);

            //Add all directories into classPath
            createClassPath(workDir, file);

            //Add the classPath with unJar files into the Javassist ClassPool
            ClassPool pool = ClassPool.getDefault();
            pool.insertClassPath(workDir + "/");
            loader.run(mainClassName, null);

          }

    } catch (Throwable e) {
        e.printStackTrace();
    }

    System.out.println("Instrumentation of " + args[0] + " finished.");
}