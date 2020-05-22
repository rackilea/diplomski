if (opcode == INVOKESPECIAL) {
    // Invoke constructors and private methods

    // Ignore initialization of java/lang/Object
    if (name.equals("<init>") && owner.equals("java/lang/Object")) {
        super.visitMethodInsn(opcode, owner, name, desc);
        return;
    }

    if (methodName.equals("<clinit>")) {

        if (name.equals("<clinit>")) {
            // call to a static initializer from within a static initializer
            // there is no object reference!
            super.visitMethodInsn(opcode, owner, name, desc);
        } else if (name.equals("<init>")) {
            // call to a constructor from within a static initializer
            super.visitMethodInsn(opcode, owner, name, desc);
            // object reference is initialized and on stack now -> obtain it via DUP
        } else {
            // call to a private method from within a static initializer
            // no this-reference in static initializer!
            super.visitMethodInsn(opcode, owner, name, desc);
        }

    } else if (methodName.equals("<init>")) {

        if (name.equals("<clinit>")) {
            // call to a static initializer from within a constructor
            // there is no object reference!
            super.visitMethodInsn(opcode, owner, name, desc);
        } else if (name.equals("<init>")) {
            // call to a constructor from within a constructor
            super.visitMethodInsn(opcode, owner, name, desc);
            // if this constructor call is not an invocation of the super constructor: obtain object reference via DUP
        } else {
            // call to a private method from within a constructor
            // object reference is the this-reference (at local variable 0)
            super.visitMethodInsn(opcode, owner, name, desc);
        }

    } else {

        if (name.equals("<clinit>")) {
            // call to a static initializer from within some method
            // there is no object reference!
            super.visitMethodInsn(opcode, owner, name, desc);
        } else if (name.equals("<init>")) {
            // call to a constructor from within some method
            super.visitMethodInsn(opcode, owner, name, desc);
            // obtain object reference via DUP
        } else {
            // call to a private method from within some method
            // if the private method is called within some NON-STATIC method: object reference is the this-reference (at local variable 0)
            // if the private method is called within some NON-STATIC method: there is no object reference!
            super.visitMethodInsn(opcode, owner, name, desc);
        }
    }
}