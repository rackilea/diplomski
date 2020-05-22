import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

// . . .

public static boolean usesP2(Evaluator evaluator) {
    AtomicBoolean usesP2 = new AtomicBoolean(false);
    String internalName = evaluator.getClass().getName().replace('.', '/');
    String classFileResource = "/" + internalName + ".class";

    ClassVisitor visitor = new ClassVisitor(Opcodes.ASM6) {
        @Override
        public MethodVisitor visitMethod(int access, String name,
                String desc, String signature, String[] exceptions) {
            if ("evaluate".equals(name)) {
                return new MethodVisitor(Opcodes.ASM6) {
                    @Override
                    public void visitVarInsn(final int insn, final int slot) {
                        if (slot == 2) usesP2.set(true);
                    }
                };
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    };
    try (InputStream is = Evaluator.class.getResourceAsStream(classFileResource)) {
        ClassReader reader = new ClassReader(is);
        reader.accept(visitor, 0);
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
    return usesP2.get();
}

public static void assertCorrectlyDocumentsP2(Evaluator evaluator) {
    boolean usesP2 = usesP2(evaluator);
    if (usesP2 && !evaluator.requiresP2()) {
        throw new AssertionError(evaluator.getClass().getName() +
                " uses P2 without documenting it");
    }
    if (!usesP2 && evaluator.requiresP2()) {
        throw new AssertionError(evaluator.getClass().getName() +
                " says it uses P2 but does not");
    }
}