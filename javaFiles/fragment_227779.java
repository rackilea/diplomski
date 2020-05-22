for(VirtualMachineDescriptor d: VirtualMachine.list()) {
    System.out.println(d.id()+"\t"+d.displayName());
    try {
        VirtualMachine vm = VirtualMachine.attach(d);
        try(Closeable c = vm::detach) {
            System.out.println("\tcurrent dir: "+vm.getSystemProperties().get("user.dir"));
        }
    }
    catch(AttachNotSupportedException|IOException ex) {
        System.out.println("\t"+ex);
    }
}