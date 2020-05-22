Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
Debug.getMemoryInfo(memoryInfo);

String memMessage = String.format("Memory: Pss=%.2f MB,
    Private=%.2f MB, Shared=%.2f MB",
    memoryInfo.getTotalPss() / 1000,
    memoryInfo.getTotalPrivateDirty() / 1000,
    memoryInfo.getTotalSharedDirty() / 1000);