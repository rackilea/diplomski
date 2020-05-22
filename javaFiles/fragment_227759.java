public static void getSystemStatistics(){
    Mem mem = null;
    CpuPerc cpuperc = null;
    FileSystemUsage filesystemusage = null;
    try {
        mem = sigar.getMem();
        cpuperc = sigar.getCpuPerc();
        filesystemusage = sigar.getFileSystemUsage("C:");          
    } catch (SigarException se) {
        se.printStackTrace();
    }


    System.out.print(mem.getUsedPercent()+"\t");
    System.out.print((cpuperc.getCombined()*100)+"\t");
    System.out.print(filesystemusage.getUsePercent()+"\n");
}