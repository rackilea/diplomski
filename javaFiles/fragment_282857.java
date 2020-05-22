VirtualMachine vm = com.sun.tools.attach.VirtualMachine.attach(PID);
    try {
        Properties props = vm.getAgentProperties();
        System.out.println(props.getProperty("sun.jdwp.listenerAddress"));
    } finally {
        vm.detach();
    }