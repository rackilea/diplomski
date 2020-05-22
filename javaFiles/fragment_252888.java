public class ClassAdapter extends ClassVisitor {
    public ClassAdapter(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
            String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        return new MethodAdapter(mv);
    }
}

public class MethodAdapter extends MethodVisitor {
    public MethodAdapter(MethodVisitor mv) {
        super(Opcodes.ASM5, mv);
    }

    @Override
    public void visitLocalVariable(String name, String desc, String signature,
            Label start, Label end, int index) {
        // Put your rename logic here
        if (name.equals("c"))
            name = "e";
        else if (name.equals("d"))
            name = "f";
        super.visitLocalVariable(name, desc, signature, start, end, index);
    }
}