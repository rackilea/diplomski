catch (InterruptedException e) {
    e.printStackTrace();
    System.out.println(threadName + " was Interupted!");
    Thread.currrentThread().interrupt();
    break;
}