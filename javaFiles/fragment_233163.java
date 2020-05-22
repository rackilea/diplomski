List<GarbageCollectorMXBean> gcList = ManagementFactory.getGarbageCollectorMXBeans();
    for(GarbageCollectorMXBean tmpGC : gcList){

        System.out.println("\nName: " + tmpGC.getName());
        System.out.println("Collection count: " + tmpGC.getCollectionCount());
        System.out.println("Collection time: " + tmpGC.getCollectionTime());
        System.out.println("Memory Pools: ");

        String[] memoryPoolNames = tmpGC.getMemoryPoolNames();
        for(String mpnTmp : memoryPoolNames){
            System.out.println("\t" + mpnTmp);
        }

    }

    System.out.println( "Memory Pools Info" );
    List<MemoryPoolMXBean> memoryList = ManagementFactory.getMemoryPoolMXBeans();
    for(MemoryPoolMXBean tmpMem : memoryList){

        System.out.println("\nName: " + tmpMem.getName());
        System.out.println("Usage: " + tmpMem.getUsage());
        System.out.println("Collection Usage: " + tmpMem.getCollectionUsage());
        System.out.println("Peak Usage: " + tmpMem.getPeakUsage());
        System.out.println("Type: " + tmpMem.getType());
        System.out.println("Memory Manager Names: ") ;

        String[] memManagerNames = tmpMem.getMemoryManagerNames();
        for(String mmnTmp : memManagerNames){
            System.out.println("\t" + mmnTmp);
        }
        System.out.println("\n");
    }

    MemoryUsage mu =ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
    MemoryUsage muNH =ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
    System.out.println(
            "Init :"+mu.getInit()+
            "\nMax :"+mu.getMax()+
            "\nUsed :"+mu.getUsed()+
            "\nCommited :"+mu.getCommitted()+
            "\nInit NH :"+muNH.getInit()+
            "\nMax NH :"+muNH.getMax()+
            "\nUsed NH:"+muNH.getUsed()+
            "\nCommited NH:"+muNH.getCommitted());