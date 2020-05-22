try(InputStream is=javax.swing.JComponent.class.getResourceAsStream("JComponent.class")) {
    ClassFile​ cf = new ClassFile(new DataInputStream(is));
    for(Object miO: cf.getMethods()) {
        MethodInfo mi = (MethodInfo)miO;
        CodeAttribute ca = mi.getCodeAttribute();
        if(ca == null) continue; // abstract or native
        int bLen = ca.getCode().length;
        if(bLen > 300)
            System.out.println(mi.getName()+" "+mi.getDescriptor()+", "+bLen+" bytes");
    }
}