public void exeTime(Runnable code){
    long start = System.currentTimeMillis();
    code.run();
    long end = System.currentTimeMillis() - start;
    System.out.println("Execution time: " + end + "ms");
}