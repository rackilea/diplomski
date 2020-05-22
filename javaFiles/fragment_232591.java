public class Int2Bool {
    public static void main(String[] args) throws IOException {
        String clName = Example.class.getName();
        ClassReader cr = new ClassReader(clName);
        ClassWriter cw = new ClassWriter(cr, 0);
        cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                if(name.equals("i2b") && desc.equals("(I)Z")) return null;
                return new MethodVisitor(Opcodes.ASM5, super.visitMethod(access, name, desc, signature, exceptions)) {
                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                        if(opcode == Opcodes.INVOKESTATIC && name.equals("i2b") &&  desc.equals("(I)Z"))
                            return;
                        super.visitMethodInsn(opcode, owner, name, desc, itf);
                    }
                };
            }
        }, 0);
        byte[] code = cw.toByteArray();
        if(writeBack(clName, code))
            Example.run();
        else
            runDynamically(clName, code);
    }
    private static boolean writeBack(String clName, byte[] code) {
        URL u = Int2Bool.class.getResource("/"+clName.replace('.', '/')+".class");
        if(u==null || !u.getProtocol().equals("file")) return false;
        try {
            Files.write(Paths.get(u.toURI()), code, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch(IOException|URISyntaxException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private static void runDynamically(String clName, byte[] code) {
        // example run
        Class<?> rtClass = new ClassLoader() {
            Class<?> get() { return defineClass(clName, code, 0, code.length); }
        }.get();
        try {
            rtClass.getMethod("run").invoke(null);
        } catch (ReflectiveOperationException ex) {
            ex.printStackTrace();
        }
    }
}