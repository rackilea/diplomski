String warName = "wlaj.war";
ClassLoader loader = new ClassLoader() {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // This probably needs fixing:
        String fileName = name.replace('.', '/') + ".class";
        try {
            try (ZipFile zf = new ZipFile(warName)) {
                ZipEntry jar = zf.getEntry("WEB-INF/lib/jlaj.jar");
                if (jar == null)
                    throw new ClassNotFoundException("No jlaj.jar");
                try (ZipInputStream jarInput = new ZipInputStream(zf.getInputStream(jar))) {
                    for (ZipEntry cl; (cl = jarInput.getNextEntry()) != null; ) {
                        if (fileName.equals(cl.getName())) {
                            ByteArrayOutputStream data = new ByteArrayOutputStream();
                            byte[] buffer = new byte[4096];
                            for (int len; (len = jarInput.read(buffer)) != -1; ) {
                                data.write(buffer, 0, len);
                            }
                            buffer = data.toByteArray();
                            return defineClass(name, buffer, 0, buffer.length);
                        }
                    }
                }
            }
            throw new ClassNotFoundException();
        } catch (IOException ex) {
            throw new ClassNotFoundException("Error opening class file", ex);
        }
    }
};
loader.loadClass("jlaj.NewJFrame");