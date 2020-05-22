// note: this list MUST correspond to native secure.c file
private static String[] secureVmArgs = {
    "-d32",                         /* use 32-bit data model if available */
    "-client",                      /* to select the "client" VM */
    "-server",                      /* to select the "server" VM */
    "-verbose",                     /* enable verbose output */
    "-version",                     /* print product version and exit */
    "-showversion",                 /* print product version and continue */
    "-help",                        /* print this help message */
    "-X",                           /* print help on non-standard options */
    "-ea",                          /* enable assertions */
    "-enableassertions",            /* enable assertions */
    "-da",                          /* disable assertions */
    "-disableassertions",           /* disable assertions */
    "-esa",                         /* enable system assertions */
    "-enablesystemassertions",      /* enable system assertions */
    "-dsa",                         /* disable system assertione */
    "-disablesystemassertions",     /* disable system assertione */
    "-Xmixed",                      /* mixed mode execution (default) */
    "-Xint",                        /* interpreted mode execution only */
    "-Xnoclassgc",                  /* disable class garbage collection */
    "-Xincgc",                      /* enable incremental gc. */
    "-Xbatch",                      /* disable background compilation */
    "-Xprof",                       /* output cpu profiling data */
    "-Xdebug",                      /* enable remote debugging */
    "-Xfuture",                     /* enable strictest checks */
    "-Xrs",                         /* reduce use of OS signals */
    "-XX:+ForceTimeHighResolution", /* use high resolution timer */
    "-XX:-ForceTimeHighResolution", /* use low resolution (default) */
    "-XX:+PrintGCDetails",          /* Gives some details about the GCs */
    "-XX:+PrintGCTimeStamps",       /* Prints GCs times happen to the start of the application */
    "-XX:+PrintHeapAtGC",           /* Prints detailed GC info including heap occupancy */
    "-XX:PrintCMSStatistics",       /* If > 0, Print statistics about the concurrent collections */
    "-XX:+PrintTenuringDistribution",  /* Gives the aging distribution of the allocated objects */
    "-XX:+TraceClassUnloading",     /* Display classes as they are unloaded */
    "-XX:SurvivorRatio",            /* Sets the ratio of the survivor spaces */
    "-XX:MaxTenuringThreshol",      /* Determines how much the objects may age */
    "-XX:CMSMarkStackSize",
    "-XX:CMSMarkStackSizeMax",
    "-XX:+CMSClassUnloadingEnabled",/* It needs to be combined with -XX:+CMSPermGenSweepingEnabled */
    "-XX:+CMSIncrementalMode",      /* Enables the incremental mode */
    "-XX:CMSIncrementalDutyCycleMin",  /* The percentage which is the lower bound on the duty cycle */
    "-XX:+CMSIncrementalPacing",    /* Automatic adjustment of the incremental mode duty cycle */
    "-XX:CMSInitiatingOccupancyFraction",  /* Sets the threshold percentage of the used heap */
    "-XX:+UseConcMarkSweepGC",      /* Turns on concurrent garbage collection */
    "-XX:-ParallelRefProcEnabled",
    "-XX:ParallelGCThreads",        /* Sets the number of parallel GC threads */
    "-XX:ParallelCMSThreads",
    "-XX:+DisableExplicitGC",       /* Disable calls to System.gc() */
    "-XX:+UseCompressedOops",       /* Enables compressed references in 64-bit JVMs */
    "-XX:+UseG1GC",
    "-XX:GCPauseIntervalMillis",
    "-XX:MaxGCPauseMillis"          /* A hint to the virtual machine to pause times */
};