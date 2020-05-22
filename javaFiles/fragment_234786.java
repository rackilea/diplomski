SerialVersionUIDAdder svuidv = new SerialVersionUIDAdder(Opcodes.ASM5, null) {
        public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
            if ("serialVersionUID".equals(name)) {
                return null;
            }
            return super.visitField(access, name, desc, signature, value);
        }

        protected void addSVUID(long svuid) {
            if(svuid!=expectedsvid) {
                throw new AssertionError("Serialization issue!");
            }
        }
    };

    InputStream is = AA.class.getResourceAsStream("/" + AA.class.getName().replace('.', '/') + ".class");
    ClassReader cr = new ClassReader(is);
    cr.accept(svuidv, ClassReader.SKIP_CODE);