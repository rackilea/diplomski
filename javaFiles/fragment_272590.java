public class JarFileClassTransformer implements ClassFileTransformer {

private String jarFileName = null;
protected Map<String, InputStream> classNames = new HashMap<>();
static Instrumentation instrumentation = null;

/**
 * Constructor.
 * @param jarFileName
 */
public JarFileClassTransformer(String jarFileName) {
    this.jarFileName = jarFileName;

    File file  = new File(jarFileName);
    System.out.println("Jar file '" + this.jarFileName + "' " + (file.exists() ? "exists" : "doesn't exists!"));

    if(file.exists()) {
        try {
            JarFile jarFile = new JarFile(file);
            Enumeration e = jarFile.entries();

            while (e.hasMoreElements()) {
                JarEntry je = (JarEntry) e.nextElement();
                if(je.isDirectory() || !je.getName().endsWith(".class")){
                    continue;
                }
                // -6 because of .class
                String jarClassName = je.getName().substring(0,je.getName().length()-6);
                jarClassName = jarClassName.replace('/', '.');
                System.out.println("Adding class " + jarClassName);
                this.classNames.put(jarClassName, jarFile.getInputStream(je));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

@Override
public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

    if(classNames.containsKey(className.replace("/", "."))) {
        System.out.format("\n==> Found %s to replace with the existing version\n", className);
        try {

            Class c = loader.loadClass(className.replace("/", "."));
            System.out.println("Existing class: " + c);
            InputStream is = classNames.get(className.replace("/", "."));

            byte[] content = new byte[is.available()];
            is.read(content);

            System.out.println("Original class version: " + ((classfileBuffer[6]&0xff)<<8 | (classfileBuffer[7]&0xff)));
            System.out.println("Redefined class version: " + ((content[6]&0xff)<<8 | (content[7]&0xff)));

            System.out.println("Original bytecode: " + new String(classfileBuffer));
            System.out.println("Redefined byte code: " + new String(content));
            ClassDefinition cd = new ClassDefinition(c, content);
            instrumentation.redefineClasses(cd);

            return content;
        } catch (Throwable e) {
            e.printStackTrace();

        }

    }
    return classfileBuffer;
}