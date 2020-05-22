private Object lock = new Object();
public void run() //gets pages and writes to them
{ // i printed the pageId of every process to check they are running at the same time and competing for resources
    for(ProcessCycle currentCycle : processCycles.getProcessCycles())
    {
        Long[] longArray = new Long[currentCycle.getPages().size()];
        try {
            synchrnonized(lock) {
                Page<byte[]>[] newPages = mmu.getPages(currentCycle.getPages().toArray(longArray));
                for(int i = 0; i < newPages.length; i++)
                {
                    MMULogger.getInstance().write("GP:P" + id + " " + currentCycle.getPages().get(i) + " " + Arrays.toString(currentCycle.getData().get(i)), Level.INFO);
                }
            }
            List<byte[]> currentPageData = currentCycle.getData();
            System.out.println("process id " + id);
            for(int i = 0; i < newPages.length;i++)
            {
                byte[] currentData = currentPageData.get(i);
                newPages[i].setContent(currentData);
            }
            Thread.sleep(currentCycle.getSleepMs());
        } catch (ClassNotFoundException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}