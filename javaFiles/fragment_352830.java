ClassReader cr = new ClassReader(bytesOfSomeClass);
//Used class node instead of visiter
ClasaNode cn = new ClassNode(<asm version>);

cr.accept(cn, 0);

//Iterate all methods of class
cn.methods.forEach( (MethodNode mn) -> {
    String callerName = mn.name;

    //Iterate all instructions of current method
    Stream.iterate(mn.instructions.getFirst(), AbstractInsnNode::getNext).limit(instructions.size())
        .filter(node -> node instanceof MethodInsnNode) //take only method calls
        .forEach(node -> {
            String calledName = ((MethodInsnNode) node).name;
            //Print results
            System.out.println(calledName + " is called by " + callerName);
         });
});