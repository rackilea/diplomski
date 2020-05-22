for(int i = 0; i < 1000; i++){
    // Uses isInterrupted() to keep interrupted status set
    if (Thread.currentThread().isInterrupted()) {
        // Cannot use InterruptedException since it's checked
        throw new RuntimeException(); 
    }
    System.out.println(i);
}