class ModifyingClassLoader extends URLClassLoader {

    // TODO: add constructors

    private boolean needsModifying(String name) {
        // TODO
    }

    private byte[] modifyClass(InputStream original) throws IOException {
        // TODO
    }

    public Class<?> findClass(String name) throws {
        if(needsModifying(name)) {
            try {
                InputStream classData = getResourceAsStream(name.replace('.', '/') + ".class");
                if(classData == null) {
                    throw new ClassNotFoundException("class " + name + " is not findable");
                }
                byte[] array = modifyClass(classData);
                return defineClass(name, array, 0, array.length);
            }
            catch(IOException io) {
                throw new ClassNotFoundException(io);
            }
        }
        else {
            return super.findClass(name);
        }
    }
}