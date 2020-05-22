final List<String> classFiles = new ArrayList<>();
StandardJavaFileManager inner = compiler.getStandardFileManager(null, null, null);
JavaFileManager fileManager = new ForwardingJavaFileManager(inner) {
    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className,
                JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        JavaFileObject o = super.getJavaFileForOutput(location, className, kind, sibling);
        classFiles.add(o.getName());
        return o;
    }
};