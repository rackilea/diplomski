ClassWriter cw = ...
cw.visit(...);
ClassReader cr1 = new ClassReader("foo.Bar"), cr2 = new ClassReader("qux.Baz");
cr1.accept(new MergeGuard(cw), 0);
cr2.accept(new MergeGuard(cw), 0);
cw.visitEnd();