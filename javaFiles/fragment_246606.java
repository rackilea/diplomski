final Sigar sigar = new Sigar();        
    final long[] processes;
    try {
        processes = sigar.getProcList();
    } catch (Exception e) {
        //throw exception.
    }