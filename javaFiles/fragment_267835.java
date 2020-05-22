import org.objectweb.asm.*;
public class FooSpyMaker implements Opcodes {
  public static byte[] dump() throws Exception {
    ClassWriter cw = new ClassWriter(0);
    cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "Spy", null, "java/lang/Object",null);
    MethodVisitor ctor = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
    ctor.visitCode();
    ctor.visitVarInsn(ALOAD, 0);
    ctor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
    ctor.visitInsn(RETURN);
    ctor.visitMaxs(1, 1);
    ctor.visitEnd();
    MethodVisitor getBaz = cw.visitMethod(ACC_PUBLIC, "getBaz",
        "(LFoo;)Ljava/lang/Object;", null, null);
    getBaz.visitCode();
    getBaz.visitVarInsn(ALOAD, 1);
    getBaz.visitMethodInsn(INVOKESTATIC, "Foo", "access$000",
        "(LFoo;)Ljava/lang/Object;");
    getBaz.visitInsn(ARETURN);
    getBaz.visitMaxs(1, 2);
    getBaz.visitEnd();
    cw.visitEnd();
    return cw.toByteArray();
  }
}