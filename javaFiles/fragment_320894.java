Path targetPath = …
String clName = "TestClass", srcName = clName+".jasm", binName = clName+".class";
Path srcFile = targetPath.resolve(srcName), binFile = targetPath.resolve(binName);
ClassWriter actualCW = new ClassWriter(0);
try(PrintWriter sourceWriter = new PrintWriter(Files.newBufferedWriter(srcFile))) {
    LineNumberTextifier lno = new LineNumberTextifier();
    TraceClassVisitor classWriter = new TraceClassVisitor(actualCW, lno, sourceWriter);
    classWriter.visit(V1_8, ACC_PUBLIC, clName, null, "java/lang/Object", null);
    MethodVisitor constructor
        = classWriter.visitMethod(ACC_PRIVATE, "<init>", "()V", null, null);
    constructor.visitVarInsn(ALOAD, 0);
    constructor.visitMethodInsn(
        INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
    constructor.visitInsn(RETURN);
    constructor.visitMaxs(1, 1);
    constructor.visitEnd();
    MethodVisitor main = classWriter.visitMethod(
        ACC_PUBLIC|ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
    Label start = new Label(), end = new Label();
    main.visitLabel(start);
    lno.updateLineInfo(main);
    main.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    lno.updateLineInfo(main);
    main.visitLdcInsn("hello world");
    lno.updateLineInfo(main);
    main.visitMethodInsn(
        INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    lno.updateLineInfo(main);
    main.visitInsn(RETURN);
    main.visitLabel(end);
    main.visitLocalVariable("arg", "[Ljava/lang/String;", null, start, end, 0);
    main.visitMaxs(2, 1);
    main.visitEnd();
    classWriter.visitSource(srcName, null);
    classWriter.visitEnd(); // writes the buffered text
}
Files.write(binFile, actualCW.toByteArray());