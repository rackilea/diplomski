Path inputDir = Paths.get("target/classes");
Path outputDir = Paths.get("target/classes2");

ClassPool classPool = new ClassPool(true);
classPool.appendClassPath(inputDir.toString());

// get all class names from a certain directory
String[] classNames = Files.walk(inputDir)
        .filter(p -> (!Files.isDirectory(p)) && p.toString().endsWith(".class"))
        .map(p -> inputDir.relativize(p).toString())
        .map(s -> s.substring(0, s.length() - 6).replace(File.separatorChar, '.'))
        .toArray(size -> new String[size]);

for (String className : classNames) {
    CtClass clazz = classPool.get(className);
    // add further filtering to select the classes you want.

    // ex: "public void serializer(java.io.DataOutput out) { out.writeInt(x); } }"
    String serializerBody = generateSerializer(clazz);
    clazz.addMethod(CtNewMethod.make(serializerBody, clazz));

    // ex: "public void deserializer(java.io.DataInput in) { x = in.readInt(); } }";
    String deserializerBody = generateDeserializer(clazz);
    clazz.addMethod(CtNewMethod.make(deserializerBody, clazz));

    // save the modified class
    clazz.setModifiers(clazz.getModifiers() & ~Modifier.ABSTRACT);
    byte[] bytes = clazz.toBytecode();
    Path outFile = outputDir.resolve(className.replace('.', '/') + ".class");
    Files.createDirectories(outFile.getParent());
    Files.write(outFile, bytes);
}